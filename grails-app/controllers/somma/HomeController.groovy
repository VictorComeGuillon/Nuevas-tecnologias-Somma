package somma

class HomeController {

	def HomeService

	def index() {
		[name: session.name ?: 'User', documentList: Document.listOrderByCreation_date(order : "desc"), documentTotal: Document.count()]
	}

	def test() {
		[projectList: Project.list()]
	}


	def project() {
		Long test = (params.id).toLong()
		def cache = Project.get(test)
		session.project = cache
		flash.message = cache
		[domainsProjectList: Domain.where {project.id == test}.list(), documentList: Document.where {project.id == test}.list()]
	}

	def domain() {
		Long test = (params.id).toLong()
		def cache = Domain.get(test)
		session.domain = cache
		Long aver = (session.project.id).toLong()
		[domain: session.domain,project: session.project, documentList: Document.where {project.id == aver && domain.id == test}.list(), domainsProjectList: Domain.where {project.id == aver}.list()]

	}

	def updateName(String name) {

		session.name = name 

		flash.message = "Name has been updated" 

		redirect action: 'index' 
	}

	def create() {
		[domainList: Domain.list(), projectList: Project.list()]

	}

	def upload(long id) {
		def file = request.getFile('file')

		Long aver = (session.project.id).toLong()
		def project = Project.get(aver)
		
		Long test = (session.domain.id).toLong()
		def domain = Domain.get(test)

		if(file.empty) {
			flash.message = "File cannot be empty"
			} else {
				def document = new Document()

				document.name = file.originalFilename
				document.path = grailsApplication.config.uploadFolder + project.name + '/' + domain.name + '/' + document.name
				file.transferTo(new File(document.path))
				project.addToDocument(document)
				domain.addToDocument(document)
				project.save()
				domain.save()
				document.save()
				redirect controller: 'Home', view: 'domain'
			}
		}

		def download(long id) {
			Document document = Document.get(id)
			if ( document == null) {
				flash.message = "Document not found."
				redirect (controler: 'document', action:'index')
				} else {
					response.setContentType("APPLICATION/OCTET-STREAM")
					response.setHeader("Content-Disposition", "Attachment;Filename=\"${document.name}\"")
					def file = new File(document.path)
					def fileInputStream = new FileInputStream(file)
					def outputStream = response.getOutputStream()
					byte[] buffer = new byte[4096];
					int len;
					while ((len = fileInputStream.read(buffer)) > 0) {
						outputStream.write(buffer, 0, len);
					}
					outputStream.flush()
					outputStream.close()
					fileInputStream.close()
				}
			}

		}
