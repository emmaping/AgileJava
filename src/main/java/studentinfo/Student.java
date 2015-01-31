package studentinfo;

public class Student {
	private String name;
	
	public Student(String name){
		this.name = name ;
	}
	
	String getName(){
		return this.name;
	}
	void setName(String name){
		this.name = name;
	}
}
