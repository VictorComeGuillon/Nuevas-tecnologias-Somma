package somma

class ProjectController {

	def AccessControlService

	static scaffold = Project
	def index() { 
		params.max = 10 
		[projectList: Project.list(params), projectCount: Project.count()]
	}



	def home(){

		[documentList: Document.findAllById(params.id)]

	}

	def login(){

	}

	def signIn = {
        if (!AccessControlService.login(
                params.key_project)) {
            redirect action: "index"
        }
        else {
            redirect uri: "/"
        }
    }

    def signOut() {
        AccessControlService.logout()
        redirect uri: "/"
    }
}
