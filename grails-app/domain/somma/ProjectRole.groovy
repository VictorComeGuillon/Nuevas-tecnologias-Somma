package somma

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.codehaus.groovy.util.HashCodeHelper
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@ToString(cache=true, includeNames=true, includePackage=false)
class ProjectRole implements Serializable {

	private static final long serialVersionUID = 1

	Project project
	Role role

	@Override
	boolean equals(other) {
		if (other instanceof ProjectRole) {
			other.projectId == project?.id && other.roleId == role?.id
		}
	}

    @Override
	int hashCode() {
	    int hashCode = HashCodeHelper.initHash()
        if (project) {
            hashCode = HashCodeHelper.updateHash(hashCode, project.id)
		}
		if (role) {
		    hashCode = HashCodeHelper.updateHash(hashCode, role.id)
		}
		hashCode
	}

	static ProjectRole get(long projectId, long roleId) {
		criteriaFor(projectId, roleId).get()
	}

	static boolean exists(long projectId, long roleId) {
		criteriaFor(projectId, roleId).count()
	}

	private static DetachedCriteria criteriaFor(long projectId, long roleId) {
		ProjectRole.where {
			project == Project.load(projectId) &&
			role == Role.load(roleId)
		}
	}

	static ProjectRole create(Project project, Role role, boolean flush = false) {
		def instance = new ProjectRole(project: project, role: role)
		instance.save(flush: flush)
		instance
	}

	static boolean remove(Project u, Role r) {
		if (u != null && r != null) {
			ProjectRole.where { project == u && role == r }.deleteAll()
		}
	}

	static int removeAll(Project u) {
		u == null ? 0 : ProjectRole.where { project == u }.deleteAll() as int
	}

	static int removeAll(Role r) {
		r == null ? 0 : ProjectRole.where { role == r }.deleteAll() as int
	}

	static constraints = {
	    project nullable: false
		role nullable: false, validator: { Role r, ProjectRole ur ->
			if (ur.project?.id) {
				if (ProjectRole.exists(ur.project.id, r.id)) {
				    return ['userRole.exists']
				}
			}
		}
	}

	static mapping = {
		id composite: ['project', 'role']
		version false
	}
}
