package somma
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class DomainController {

	static scaffold = Domain

	def index(){
		[domainList: Domain.list(), domainCount: Domain.count()]
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


}