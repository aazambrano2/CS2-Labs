/*************************************************************************
 * This class is the blueprint for any student. 
 * It describes what its attributes and 
 * how to operate it (its methods).
 * YOU CANNOT MODIFY THIS FILE
 *************************************************************************/ 

public class Student {

	private String name; // includes first and last names
	private String major;
	private int ID;
	
	/* CONSTRUCTORS ***********************************************/
	public Student(String name, String major, int id) {
		this.name = name;
		this.major = major;
		this.ID = id;
	}
	
	public Student() {}

	/* GETTERS ****************************************************/
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}
	
	/**
	 * @return the id
	 */
	public int getID() {
		return ID;
	}
	
	/* SETTERS ****************************************************/
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setID(int id) {
		this.ID = id;
	}

	/* OTHER METHODS ***********************************************/
	/**
	 * returns a string of the name, ID, and major of the student
	 */
	public String toString() {
		return (name + " (" + ID + ") " + major + "\n");
	}
	
}
