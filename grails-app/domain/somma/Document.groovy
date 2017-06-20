package somma

class Document {
	
	String name
	Date creation_date = new Date()
	String path

	static belongsTo = [project: Project, domain: Domain, user: User]


	String toString() { return name }

	static constraints = {
		path blank: false, nullable: false, unique:true
		name blank: false, nullable: false
	}

	static mapping = {
		sort creation_date: "desc"
	}
	
	
}
