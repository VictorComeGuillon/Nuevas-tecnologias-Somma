package somma
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityService
import org.springframework.security.core.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.*



@Secured('ROLE_ADMIN')
class HomeController {

	def HomeService
    def springSecurityService

	def index() {
		def user = springSecurityService.currentUser
		def userProjectList = Project.where {user.id == user.id}.list()
		def counter = Project.where {user.id == user.id}.count()
		
		if(counter == 1){

			redirect view: 'project', id: userProjectList.id
		
		}else{

		[username: user, userProjectList: userProjectList]

		}
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

		def user = springSecurityService.currentUser

		if(file.empty) {
			flash.message = "File cannot be empty"
			} else {
				def document = new Document()

				document.name = file.originalFilename
				document.path = grailsApplication.config.uploadFolder + project.name + '/' + domain.name + '/' + document.name
				file.transferTo(new File(document.path))
				project.addToDocument(document)
				domain.addToDocument(document)
				user.addToDocument(document)
				project.save()
				domain.save()
				user.save()
				document.save()

				redirect action: 'project' id: aver
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
