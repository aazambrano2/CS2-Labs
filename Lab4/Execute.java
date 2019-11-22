/**
 * 
 * @author mceberio
 * @student Aaron Zambrano <-- FILL IN HERE WITH YOUR NAME
 *
 */

import java.io.*;

public class Execute {
	/**
	 * 
	 * @param filename
	 * @return the number of students in the file called filename
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
    public static int numStudents(String filename) throws FileNotFoundException, IOException {
        /* MAKE SURE THAT THE NUMBER OF LINES IS CONSISTENT WITH WHAT YOU ARE EXPECTING
         * FOR INSTANCE: IS THE NUMBER OF LINES IS NOT A MULTIPLE OF 3, THERE IS A PROBLEM
         */
        FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);
        int count = 1;
        int studentNum = 0;
        while(textReader.ready()){
            textReader.readLine();
            count++;
            if(count % 3 == 0){   //Student's information ends when count is 3 * n where n is the line number in studentsInfo.txt
               studentNum++; //count of students
            }
        }
        return studentNum;
    }
    /**
     * 
     * @param filename
     * @return a 1D array of Students whose information was read in the file called filename
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static Student[] readStudentInfo(String filename) throws FileNotFoundException, IOException {
    	int numStudents = numStudents(filename);
    	Student[] roster = new Student[numStudents];

    	FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        int i = 0;
        int[] gradeArray;
        String [] studentGradesArray;
        while (textReader.ready()) {
            String studentName = textReader.readLine(); // Assigns the student's name to a string
            String studentMajor = textReader.readLine();// Assigns the student's major to a string
            String studentGrades = textReader.readLine();// Assigns the student's grades to a string
            studentGradesArray = studentGrades.split(" "); //converts student's grades to an String array
            gradeArray = new int[studentGradesArray.length] ; //one D array of student's grade

            for(int j = 0; j < gradeArray.length; j++){
                gradeArray[j] = Integer.parseInt(studentGradesArray[j]); //Parses each String grade to int
            }
            roster[i] = new Student(studentName, studentMajor, gradeArray); //assigns Students to each element of the roster Array
            roster[i].printAll(); //prints each Students information
            i++;                  //iteration of roster[]
        }
        textReader.close();
        return roster;
    }
 
    /**
     * 
     * @param roster: 1D array of Students
     * @return a 2D array of grades (each row corresponds to a student's list of grades)
     */
    public static int[][] gradeSheet(Student[] roster) {
    	int[][] grades = new int[roster.length][]; // CHANGE? HINT: IT DOES NOT MAKE SENSE TO ALWAYS HAVE ONLY 2 COLUMNS --> CHANGE THAT

    	for(int i = 0; i < grades.length; i++){
    	    //Rows of the grade sheet assigned to each Student's one d array of grades.
    	    grades[i] = roster[i].getGrades();
        }
    	return grades;
    }
    
    /**
     * 
     * @param gradeSheet: a 2D array of grades
     * @return the index of the row with the best average, 
     * which corresponds to the index of the Student with best average in roster
     */
    public static int bestStudentAverage(int[][] gradeSheet) {
        //Don't use student average just calculate average
        int index = 0;  // temporary variable to store the index of the row with the best average
        double sum = 0; // sum of the current row.
        double sumFirst = 0; //sum of the first row
        double currentAvg;   //temporary variable to store the current average of a row.

        //Acquire the average of grades[0]
        for(int k = 0; k < gradeSheet[0].length; k++){
            sumFirst+= gradeSheet[0][k];
        }
        double maxAvg = sumFirst / gradeSheet[0].length; // variable to store the current maximum average of a row
        for(int i = 0; i < gradeSheet.length; i++){
            for(int j = 0; j <  gradeSheet[i].length; j++){
                sum += gradeSheet[i][j];
            }
            currentAvg = sum / gradeSheet.length; //Average of the Student's grades
            if(currentAvg > maxAvg){
                maxAvg = currentAvg;
                index = i;
            }
            sum = 0; //reinitialize  sum to 0
        }
    	return index;
    }
    /**
     * 
     * @param gradeSheet: a 2D array of grades
     * @return the index of the row with the best averageW, 
     * which corresponds to the index of the Student with best averageW in roster
     */
    public static int bestStudentAverageW(int[][] gradeSheet, int[] weights) {

        double sum = 0, sumW = 0; //sum of the row and sum of the weights
        int index = 0; // temporary variable to store the index of the row with the best average
        double currentAvg; //temporary variable to store the current average of a row.
        double sumFirst = 0; //sum of the first row

        for(int k = 0; k < gradeSheet[0].length; k++){
            sumFirst+= gradeSheet[0][k];
        }
        double maxAvg = sumFirst / gradeSheet[0].length; // maximum average variable of the current row

        for(int i = 0; i < gradeSheet.length; i++){
            for(int j = 0; j <  gradeSheet[i].length; j++){
                sum += gradeSheet[i][j]*weights[j];
                sumW += weights[j];
            }
            currentAvg = sum / sumW;   //weighted average of the Student's grades
            if(currentAvg > maxAvg){
                maxAvg = currentAvg;
                index = i;
            }
            sum = 0; //reinitialize  sum to 0
            sumW = 0; // reinitialize sumW to 0
        }
        return index;
    }
	
    /**
     * 
     * @param gradeSheet: a 2D array of grades
     * @param major: a String representing the major of the Student
     * @return the index of the row with the best average, 
     * among the students with a major matching @param major,
     * which corresponds to the index of the Student with best average in roster
     */
    public static int bestStudentAverage(int[][] gradeSheet, String major, Student[] roster) {

        double sumFirst = 0;
        for(int k = 0; k < gradeSheet[0].length; k++){
            sumFirst+= gradeSheet[0][k];
        }
        double maxAvg = sumFirst / gradeSheet[0].length ;
        double currentAvg = 0;
        int index = 0;
        for(int i = 0; i < roster.length; i++) {
            if (roster[i].getMajor().equals(major)) {
                currentAvg = roster[i].average(); //current average of the row calculated by calling average() for a Student's grades
            }
            if(currentAvg > maxAvg){
                currentAvg = maxAvg;
                index = i;
            }
        }
    	return index;
    }
	
    /**
     * 
     * @param gradeSheet: a 2D array of grades
     * @param major: a String representing the major of the Student
     * @return the index of the row with the best averageW, 
     * among the students with a major matching @param major,
     * which corresponds to the index of the Student with best averageW in roster
     */
    public static int bestStudentAverageW(int[][] gradeSheet, String major, Student[] roster, int[] weights) {

      double sumFirst = 0;
        for(int k = 0; k < gradeSheet[0].length; k++){
            sumFirst+= gradeSheet[0][k];
        }
        double maxAvg = sumFirst / gradeSheet[0].length;
        double currentAvg = 0;
        int index = 0;
        for(int i = 0; i < roster.length; i++){
            if(roster[i].getMajor().equals(major)){
                currentAvg = roster[i].averageW(weights); //current average of the row calculated by calling averageW() for a Student's grades
            }
            if(currentAvg > maxAvg){
                maxAvg = currentAvg;
                index = i;
            }
        }
        return index;
    }
	
    /**
     * 
     * @param grades: a 2D array of grades
     * @return the index of the column with the best average,
     * which corresponds to the assignment with the most success in the classroom
     */
    public static int bestAssignmentAverage(int[][] grades) {
        // HINT: here, you are traversing your table column per column
        int index = 0;  //temporary variable to store the index of the column with the maximum average for assignments.
        double sumFirst = 0, sum = 0;
        double currentAvg;
        for(int i = 0; i < grades.length; i++){
          sumFirst = grades[i][0];
        }
        double maxAvg = sumFirst/grades.length;

        for( int col = 0; col < grades.length; col++){
            for(int row = 0; row < grades[col].length; row++){
                sum+= grades[row][col];   //sum of the grades of assignment at current column of the grade sheet.
            }
            currentAvg = sum / grades.length; // current average of the assignment
            if(currentAvg > maxAvg){
                maxAvg = currentAvg;
                index = col;
            }
            sum = 0; //re initialize sum to 0
        }
    	return index;
    }
	
    /**
     * 
     * @param grades: a 2D array of grades
     * @param major: a String representing the major of the Student
     * @return the index of the column with the best averageW, among only the rows
     * that correspond to students with major @param major
     * which corresponds to the assignment with the most success in the classroom
     */
    public static int bestAssignmentAverage(int[][] grades, String major, Student[] roster) {
    	// COMPLETE CODE HERE
        // HINT: here, you are traversing your table column per column
        int count = 0;
        double sumFirst = 0;
        for(int i = 0; i < grades.length; i++){
            sumFirst = grades[i][0];
        }
        double maxAvg = sumFirst/grades.length;

        boolean[] list = new boolean[grades.length]; //Array to check which Students are from a specific major

        for(int i = 0; i < roster.length; i++) {
            list[i] = roster[i].getMajor().equals(major);  //sets to true if major matches
            count++;  //count of students with the major
        }
        int maxIndex = -1; // variable to store the Index of the column with the max average among students of the major

        for(int col = 0; col < grades[0].length; col++){
            double avg = 0;
            for(int row = 0; row < grades.length; row++){
                if(list[row]){
                    avg += grades[row][col];   //average added only if Student's grades corresponds with the Student's major.
                }
                avg = avg / count;
                if(avg > maxAvg){
                    maxAvg = avg;
                    maxIndex = col;
                }
            }
        }
        return maxIndex;
    }

    /**
     * Main method: follow instructions within to test your above code 
     * @param args
     */
    public static void main(String[] args) throws IOException {
        String file = "C:/Users/Crene/IdeaProjects/Lab45/src/studentsInfo.txt";
        numStudents(file);
        int[] weights = {10,40,10,20,10,10};

    	// 1. Read the file studentsInfo.txt and generate a 1D array of Students called roster

    	Student [] roster = readStudentInfo(file);

    	// 2. Create a gradeSheet and call it grades

         int [][] grades = gradeSheet(roster);

    	// 3. Print out the gradeSheet
    	// COMPLETE CODE HERE
        for(int i = 0; i < grades.length; i++){
            for(int j = 0; j < grades[i].length; j++){
                System.out.print(grades[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println(" ");
    	// 4. Identify the student with best average and print out the student's information

        System.out.print("Student with the best average: ");
        roster[bestStudentAverage(grades)].printAll();

        System.out.print("Student with the best weighted average: ");
        roster[bestStudentAverageW(grades, weights)].printAll();
    	// 5. Identify the computer science student with best average and print out the student's information

        System.out.print("Computer Science Student with the best average: ");
        roster[bestStudentAverage(grades,"Computer Science",roster)].printAll();

    	// 6. Identify the assignment with most success and print out which assignment this was

        System.out.println("Assignment " + (bestAssignmentAverage(grades))   + " was the most successful!");

    	// 7. Identify the assignment with most success among computer science students and print out which assignment this was

        System.out.print("Best assignment average among Computer Science students: ");
        System.out.println("Assignment " + (bestAssignmentAverage (grades, "Computer Science", roster) ) );

    	// 8. Add one instruction here: write comment so we know what this is about

        //This will output the student with the best weighted average from the student roster.

        System.out.print("Student with the best weighted average: ");
        roster[bestStudentAverageW(grades, weights)].printAll();
    }
}
