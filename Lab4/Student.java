/**
 * 
 * @author mceberio
 * @student Aaron Zambrano <-- FILL IN HERE WITH YOUR NAME
 *
 */

public class Student {

	private String name; // includes first and last names
	private String major;
	private int[] grades;
	
	/* CONSTRUCTORS ***********************************************/
	public Student(String name, String major, int[] grades) {
		this.name = name;
		this.major = major;
		this.grades = grades;
	}

	/* GETTERS ****************************************************/
	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @return the major
	 */
	public String getMajor() {
		return this.major;
	}
	
	/**
	 * @return the grades
	 */
	public int[] getGrades() {
		return this.grades;
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
	 * @param grades the grades to set
	 */
	public void setGrades(int[] grades) {
		this.grades = grades;
	}

	/* OTHER METHODS ***********************************************/
	/**
	 * prints out the name and major of the student
	 */
	public void print() {
		System.out.println(this.name + ", Major: " + this.major);
	}
	/**
	 * prints out the name, major, and grades of the student
	 */
	public void printAll() {
    	// COMPLETE CODE HERE
        // DO MAKE SURE TO USE METHOD PRINT HERE
		System.out.print(this.name + " | Major: " + this.major + " | Grades: ");
		int i;
		for(i = 0; i < this.grades.length; i++){
			System.out.print(this.grades[i] + " ");
		}
		System.out.println("");
	}
		
	/* BOTH METHODS BELOW NEED TO BE TESTED USING JUNIT TESTS: 3 tests per method ******/	
	/**
	 * Method average:
	 * @return the average of all grades in array grades (without weights)
	 */
	public double average() {
		// COMPLETE CODE HERE
		double sum = 0;

		for(int i = 0; i < this.grades.length; i++){
			sum += this.grades[i];
		}
		return  sum / this.grades.length;
	}

	/**
	 * Method averageW:
	 * @return the average of all grades in array grades (with weights)
	 */
	public double averageW(int[] weights) {
		// COMPLETE CODE HERE
		int sum = 0;
		int sumW = 0;
		for(int i = 0; i < this.grades.length; i++){
			sum += this.grades[i]*weights[i];
			sumW = weights[i];
		}

		return (double) sum / sumW ;
	}

}
