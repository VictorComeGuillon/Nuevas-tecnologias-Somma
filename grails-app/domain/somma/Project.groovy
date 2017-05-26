package somma

class Project {

	static hasMany = [document: Document, domain: Domain]

	String name
	String location
	Date start_date = new Date()
	Date end_date = new Date()
	String key_project

	String toString() { return name }

	static constraints = {
		name blank: false, unique: true, nullable: false
		key_project blank: false, unique: true, size: 6..15, nullable: false
	}
}
