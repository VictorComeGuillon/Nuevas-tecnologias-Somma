

package somma

class DocumentController {

	static scaffold = Document



	def index(Integer max) {
		params.max = 10 
		[documentList: Document.list(params), documentCount: Document.count()]

	}

	def create() {
		[domainList: Domain.list(), projectList: Project.list()]

	}

	def upload(long id) {
		def file = request.getFile('file')
		def domain = Domain.get(params.domainSelection)
		def project = Project.get(params.projectSelection)
		
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
				redirect controler: 'Document', action: 'index'
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
