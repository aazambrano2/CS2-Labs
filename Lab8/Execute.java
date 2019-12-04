import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Execute {

    /* buildNetwork:
     * This method is given to you. It reads information about advisors in a file and builds a tree of 
     * these advisors.
     */
	public static BTree<Person> buildNetwork(String filename) throws FileNotFoundException, IOException {
		BTree<Person> network = new BTree<Person>();
		 
		FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        String check;
        String[] line;
        String[] person;
        String name, email;
        while (textReader.ready()) {
        	check = textReader.readLine(); 
        	line = check.split(" ");
        	for (int i=0; i<line.length; i++) {
        		person = line[i].split(",");
        		name = person[0];
        		email = person[1];
        		Person advisor = new Person(name, email);
        		network.insertDataAtLocation(person[2], advisor);
        	}
        }
        
        textReader.close();
        		
		return network;
	}
	
    /*
     * TODO 15: traverseNetwork:
     * This method traverses a BTree in a pre-order fashion, using a Stack (type StackL 
     * that you completed earlier).
     */ 
	public static void traverseNetwork(BTree<Person> network) { // pre-Order
        // Your code goes here
        System.out.println("PRE ORDER FASHION");
        StackL<BTNode> pStack;
        BTNode temp = network.getRoot();
        if(network.getRoot() != null){         //if the root data is not null
            pStack = new StackL<BTNode>();
            pStack.push(temp);
        }
        else{
            System.out.println("Cannot push an null value");
            return;
        }

        while(!pStack.isEmpty()){
            pStack.peek().printNode();
            temp = pStack.peek();
            pStack.pop();
            if(temp.hasRight()) {
                pStack.push(temp.getRight());  //push right child
            }
            if(temp.hasLeft()) {
                pStack.push(temp.getLeft());  //push left child
            }
        }
    }
	
    /*
     * TODO 16: levelOrderTraversal:
     * This method traverses a BTree in a level-order fashion, using a Queue (type QueueA 
     * that you completed earlier).
     */ 
	public static void levelOrderTraversal(BTree<Person> network) { // level-Order
        // Your code goes here
        System.out.println("LEVEL ORDER FASHION");
        QueueA<BTNode> QueueA;
        BTNode temp = network.getRoot(); // temporary reference point to root
        if(temp!= null){ //if the root is not null
            QueueA = new QueueA<BTNode>(network.getSize());
            QueueA.enqueue(temp);
        }
        else{
            System.out.println("Cannot create a queue with null data/reference");
            return;
        }
        while(!QueueA.isEmpty()){
            QueueA.peek().printNode();;
            temp =  QueueA.peek(); //temp points node of the head
            QueueA.dequeue();

            if(temp.hasLeft()) {
                QueueA.enqueue(temp.getLeft()); //enqueue left child
            }

            if(temp.hasRight()) {
                QueueA.enqueue(temp.getRight()); //enqueue right child
            }
        }
	}
	
    /*
     * TODO 17: exploreBranch:
     * This method traverses and prints the nodes of a given branch of a BTree
     * The branch is described by parameter directions, that is a string composed of letters 'L' and 'R'
     * 'L' indicates that we need to explore the branch going to the left subtree
     * 'R' indicates that we need to explore the branch going to the right subtree
     */ 
	public static void exploreBranch(BTree<Person> network, String directions) {
        // Your code goes here
        BTNode temp = network.getRoot();
        temp.printNode();
        int i=0;
        while(temp.hasLeft() || temp.hasRight()){
            if(directions.charAt(i) == 'L'){ // visit left sub tree
                if(temp.hasLeft()){          //check if the current node has a left child
                    temp = temp.getLeft();   //update location
                    temp.printNode();        //print node information
                    i++;
                }
            }
            if(directions.charAt(i) == 'R'){ //visit right sub tree
                if(temp.hasRight()){         //check if the current node has a right child
                    temp = temp.getRight();  //update location
                    temp.printNode();        //print node information
                    i++;
                }
            }

        }
        System.out.println("");
        if(i < directions.length()){
            System.out.println("Directions: " + directions + " exceed branch length");
        }
	}

    /*
     * TODO 18: complete the main method, according to the comment below
     */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String filename = args[0];
        
        // Here we create a binary tree from the advisors listed in the above text file
		BTree<Person> network = buildNetwork(filename);
        // Once the BTree is built, we print it out
		network.print();
		System.out.println();
        
        // We traverse and print the BTree called network in a pre-order fashion
		traverseNetwork(network);
		System.out.println();
        
        // We print the branch of BTree network that is described by "LLRLRLR"
		exploreBranch(network,"LLRLRLR");
		System.out.println();
        
		// We traverse and print the BTree called network in a level-order fashion
		levelOrderTraversal(network);
		
	}
}
