 
package somma

import grails.plugin.cache.*

class HomeService {

	static transactional = true

	@CachePut(value='project', key =  'project' )
	void save(Project project) {
		println "Saving project $project"
		project.save()
	}

}
