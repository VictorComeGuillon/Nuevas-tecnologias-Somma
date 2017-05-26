package somma

import grails.transaction.Transactional

@Transactional
class AccessControlService {

    static scope = "session"

    Long projectId

    void login(String key_project) {
        
        def project = Project.findByKey_project(key_project)
        if (!project) throw new RuntimeException("project $key_project not found")

        if (project) {
            projectId = project.id
        }
    }

    void logout() { this.projectId = null }
    boolean isAuthenticated() { return projectId != null }

}
