package somma
class BootStrap {

    def springSecurityService

 
    def init = { servletContext ->
 

    	def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true, flush: true)



        def adminUser = User.findByUsername('me') ?: new User(
                username: 'me',
                password: 'password',
                enabled: true).save(failOnError: true, flush: true)

        if (!adminUser.authorities.contains(adminRole)) {
            UserRole.create adminUser, adminRole
    
        }

        UserRole.withSession {
            it.flush()
            it.clear()
        }


    }

    def destroy = {
    }

}
