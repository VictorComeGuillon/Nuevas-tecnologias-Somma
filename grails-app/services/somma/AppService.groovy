package somma

import somma.Project

class AppSecurityService {

    static transactional = false

    def springSecurityService

    Project getCurrentProject(){
    	springSecurityService.currentProject
    }

    def serviceMethod() {

    }
}
