package somma

class Domain {

	static hasMany = [document: Document, project: Project] 
	String name
	static belongsTo = Project

	String toString() { return name }
	static constraints = {
		name blank:false, unique:true, inList: ["Plans Architecte", "Rapports", "Controls", "Electricite", "Charpente", "Couverture"]
	}

	
}
