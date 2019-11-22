/*************************************************************************
 * This file is where you will have to complete your assignment. 
 * Here, you will write methods that do the following:
 * 1/ read student loaner information from a file and build a linked list 
 *      of dossiers from there
 * 2/ identify a node that contains the dossier of a student with a given ID
 *      Your method is expected to be RECURSIVE
 * 3/ transfer the data from a linked list to an array
 * 4/ sort the data in the array of loaner dossiers between returned and 
 *      not returned laptops
 *      This method should be inspired by QUICK SORT
 * 5/ complete the main method as prompted
 * Note: in all your work below, you will be expected to use the methods 
 * already defined in the files provided to you (Student.java, Dossier.java,
 * Node.java, LList.java). You are not to redefined functionalities that 
 * already exist.
 *************************************************************************/ 

/**
 * 
 * @author mceberio
 * @student Aaron Zambrano <-- FILL IN HERE WITH YOUR NAME
 *
 */

import java.io.*;
import java.sql.SQLOutput;

public class LoanerProgram {

    /**
     * TASK 1.
     * @param filename
     * @return a linked list of Loaner Dossiers whose information was read in the file called filename
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static LList<Dossier> readStudentInfo(String filename) throws FileNotFoundException, IOException {
		
    	LList<Dossier> loanerList = new LList<Dossier>();
    	
    	FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        while(textReader.ready()){
            String currentLine = textReader.readLine();
            if(currentLine.equals("Dossier")) {

                //Creating an instance of Student
                Student S = new Student();
                S.setName(textReader.readLine());
                S.setID(Integer.parseInt(textReader.readLine()));

                //Creating an instance of Dossier
                Dossier DS = new Dossier(S, Integer.parseInt(textReader.readLine()));
                //Creating a node of type Dossier
                Node<Dossier> NodeDS = new Node<Dossier>(DS);

                //Prepending the Node to the start of the list
                loanerList.addStart(NodeDS);
            }

            if (currentLine.equals("Update")) {
                //Update Dossier Return date
               Node<Dossier> UpdatedDS = findStudentWithGivenID(loanerList.getHead(), Integer.parseInt(textReader.readLine()));
               // UpdatedDS.printNode();
                UpdatedDS.getData().setDateReturned(Integer.parseInt(textReader.readLine()));
            }
        }
        textReader.close();
        return loanerList;
    }
 
    /* 
     * TASK 2. //recursive method
     * Takes: a node of a Loaner Dossier and a student ID //head of list?
     * Returns: the node that corresponds to this given student's loan
     * This method MUST be used (called) within the above method: readStudentInfo
     */
    public static Node<Dossier> findStudentWithGivenID(Node<Dossier> myNode, int ID) {
        if(myNode == null){ //base case 1
            System.out.println("Roster is empty");
            return null;
        }

        if(myNode.getNext() == null){ //base case 2
            return myNode;
        }

        if(myNode.getData().getStudent().getID() == ID){
            return myNode;
        }
        return findStudentWithGivenID(myNode.getNext(), ID);
    }
    
    /* 
     * TASK 3.
     * Takes: a linked list of Loaner Dossiers 
     * Returns: an array of the size of the linked list, and that contains the same data
     *      as the linked list
     */
    public static Dossier[] createArrayOfLoanerDossiers(LList<Dossier> myList) {
        // YOUR CODE GOES HERE
        Node<Dossier> temp = myList.getHead();
        //Create Dossier array with the size of myList
       Dossier[] rosterArray = new Dossier[myList.getSize()];
       for(int i = 0; i < rosterArray.length; i++){
           rosterArray[i] = temp.getData();
           temp = temp.getNext();
       }
        return rosterArray;
    }
    
    /* 
     * TASK 4.
     * Takes an array of Loaner Dossiers
     * Re-arranges this array so that all non-returned Dossiers are at the start of the array and all returned are at the end
     * Hint: use a Quick Sort like approach
     */
    public static void sortByNotReturned(Dossier[] myList) {
        // YOUR CODE GOES HERE
        Dossier temp;
        int pivot = -1; // non return
        int indexI = 0, indexJ = 0;
        int i = 0, j = myList.length - 1;
        for(int index = 0; index < myList.length; index++) {
            while(i < myList.length){ //low
                if(myList[i].getDateReturned() != pivot){ //if the element does have a return date
                    indexI = i; //store index of the element with a return date
                    break;
                }
                i++;
            }
            while(j >0){  //high
                if(myList[j].getDateReturned() == pivot){ //if the element does not have a return date
                    indexJ = j;//store index of the element with no return date
                    break;
                }
                j--;
            }
            //Indexes cross each other
            if(j < i){
                break;
            }
            //Swap elements
            temp = myList[indexI];
            myList[indexI] = myList[indexJ];
            myList[indexJ] = temp;
        }
    }
    /*************************************EXTRA CREDIT METHODS*****************************************/
    //TODO: sortByNotReturnedByDate()
    //TODO:LatestBorrowed()

    public static boolean hasBorrowed(Dossier[] myList, int ID){
        for(int i = 0; i < myList.length; i++){
            if(myList[i].getStudent().getID() == ID){
                if(myList[i].getDateBorrowed() > 0) {
                    return true;
                }
            }
        }
        return false;
    }
    //TODO: borrowedLongest()
    public static Student borrowedLongest(Dossier[] myList){
        int max = 0;
        int diff = max;
        Student borrowed = new Student();
        for(int i = 0; i < myList.length; i++){
            if(myList[i].getDateReturned() != -1){  //has a return date
                diff = myList[i].getDateReturned() - myList[i].getDateBorrowed();
            }
            if(diff > max ){
                max = diff; //max difference between the return date and borrow date
                borrowed = myList[i].getStudent(); //student that the longest date
            }
        }
        return borrowed;
    }

    /*
     * TASK 5.
     * Complete the main method as prompted below
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String filename = "loanerInfo.txt";
        // Step 1. Create a linked list of dossiers from reading the file loanerInfo.txt
        LList<Dossier> roster = readStudentInfo(filename);

        // Step 2. Print the content of this linked list
        roster.print();

        // Step 3. Create an array of dossiers from this linked list
        Dossier[] rosterArray  = createArrayOfLoanerDossiers(roster);

        // Step 4. Sort the dossiers between not_returned (first part of the array) and returned (last part of the array)
        sortByNotReturned(rosterArray);

        // Step 5. Print the content of the array
        System.out.println("*******Roster of Dossiers in Array: ");
        System.out.println();
        for(int k = 0; k < rosterArray.length; k++){
            System.out.println(rosterArray[k] + "");
        }
        System.out.println();

        /*************************Extra Credit******************************/

        //hasBorrowed()
        System.out.println(hasBorrowed(rosterArray, 80111111));

        //borrowedLongest()
        System.out.println("Student that borrowed the longest: " + borrowedLongest(rosterArray).toString());
    }
}
