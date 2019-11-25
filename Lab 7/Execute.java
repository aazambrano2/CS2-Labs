/*************************************************************************
 * In this file, you get to use the blueprints you have participated in
 * creating (BTNode, BTree). 
 * Namely, in this file, you are going to manipulate binary trees. 
 * Most of the code is given to you. 
 *      - The main method is given to you. 
 *      - A set of helper methods are also provided to you: you may or 
 *        may not elect to use them, it is fine. 
 * There is 1 TODO in this file: TODO 6.
 * Note: You can only add code in the TODOs. You are not allowed to modify 
 * anything else in the code. 
 *************************************************************************/ 

import java.io.*;
import java.util.Scanner;
import java.util.*;

public class Execute {

    /* TODO 6: 
     * Method readFamilyIntoTree: 
     * Takes a file name and reads this file with family information, 
     * creates and fills a linked-list-based tree with family member information.
     * Note: Father-line nodes go to the left and Mother-line nodes go to the right
     ****************************************************************************************/
    public static BTree<FamilyMember> readFamilyIntoTree(String filename) throws FileNotFoundException, IOException {
        
		FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        // Create an empty binary tree of Family Members
        BTree<FamilyMember> Tree = new BTree<FamilyMember>();
        
        // YOUR CODE GOES HERE: COMPLETE HERE...
        int j = 0;
        while(j != countLines(filename)){
            String currentLine = textReader.readLine();
            if(currentLine.contains(" ")){
                String[] members = currentLine.split(" "); // Array of Information about family members
                for(int i = 0; i < members.length; i++){
                    String[] member = processLine(members[i]); // String array of a single member
                    FamilyMember fam = new FamilyMember(member[0],member[1],Integer.parseInt(member[2])); //instance of FamilyMember
                    Tree.insertDataAtLocation(member[3],fam); //inserting data at proper location
                }
            }
            else{ //if member is the root
                String[] member = processLine(currentLine);
                FamilyMember fam = new FamilyMember(member[0],member[1],Integer.parseInt(member[2]));
                Tree.insertDataAtLocation(member[3], fam);
            }
            j++;
        }
        textReader.close();

        // NOTE: Make sure that your tree has an updated size and height
        Tree.resetSize();
        Tree.resetHeight();
        // Return the resulting filled tree
        return Tree;

    }
    /****************************************************************************************   
     * Main Method: DO NOT MODIFY THE MAIN METHOD
     ****************************************************************************************/    
	public static void main(String[] args) throws FileNotFoundException, IOException {
        String filename = args[0];

        // Creates a linked-list-based tree directly from reading the file:
        BTree<FamilyMember> Tree = readFamilyIntoTree(filename);
        // Prints out the content of the linked-list-based tree:
        System.out.println();
        Tree.print();
        //Tree.inOrderTraversal(); //Extra Credit
        
        System.out.println("Tree size = " + Tree.getSize());
        System.out.println("Tree height = " + Tree.getHeight());
        System.out.println();
        System.out.println();

        /******EXTRA CREDIT: BINARY SEARCH TREE**************************/
        BSTree<Integer> Tree2 = readFamilyIntoBST(filename);
        Tree2.print();
        System.out.println("Tree size = " + Tree2.getSize());
        System.out.println("Tree height = " + Tree2.getHeight());
        System.out.println();
        System.out.println();
    }


    /******EXTRA CREDIT: BINARY SEARCH TREE*************************/
    /**
     * @param filename
     * @return A binary search tree of type Integer
     */
    public static BSTree<Integer> readFamilyIntoBST(String filename)throws FileNotFoundException, IOException {

        FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        // Create an empty binary tree of Family Members
        BSTree<Integer> TreeBST = new BSTree<Integer>();

        while(textReader.ready()){
            String currentLine = textReader.readLine();
            if(currentLine.contains(" ")){
                String[] members = currentLine.split(" "); // Array of Information about family members
                for(int i = 0; i < members.length; i++){
                    String[] member = processLine(members[i]); // String array of a single member
                    FamilyMember fam = new FamilyMember(member[0],member[1],Integer.parseInt(member[2])); //instance of FamilyMember
                    TreeBST.insert(fam.getSiblings()); //inserting data at location of the BSTree
                }
            }
            else{ //if member is the root
                String[] member = processLine(currentLine);
                FamilyMember fam = new FamilyMember(member[0],member[1],Integer.parseInt(member[2]));
                TreeBST.insert(fam.getSiblings());
            }
        }
        textReader.close();

        // NOTE: Make sure that your tree has an updated size and height
        //after I make my BTree
        TreeBST.resetSize();
        TreeBST.resetHeight();

        // Return the resulting filled tree
        return TreeBST;
    }

    /************************************************************************************
     * HELPER METHODS: ******************************************************************
     ************************************************************************************/

    /* Method processLine:
     * This method is given a String that is one element of the line in the text file for be read.
     * The element is of the following form: <String>-<String>,<int>,<String>
     * Example of such an element: John-Doe,3,LLR
     * It processes this element and produces an array of 4 strings: 
     * [first name, last name, number of siblings, location in the array where it should be stored]
     * In the case of the above example, we would produce the following array: [John, Doe, 3, LLR]
     */
    public static String[] processLine(String element) {
        String[] result = new String[4];

        String[] member = element.split(",");
        String[] name = member[0].split("-");
        result[0] = name[0];
        result[1] = name[1];
        result[2] = member[1];
        result[3] = member[2];

        return result;
    }

    /* Method countLines: 
     * This method takes a file name as a parameter and 
     * returns the number of lines in this file (an int)
     */
    public static int countLines(String filename) throws FileNotFoundException, IOException {
		FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        int counter = 0;
        // As long as there is something to read in the file...
        while (textReader.ready()) {
            // we increase our line counter
            counter++;
            // read the line and move to the next to check if there is something to read (the while condition)
            textReader.readLine();   
        }
        
        textReader.close();
        return counter;
    }


}