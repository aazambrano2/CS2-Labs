public class TestWithMain {
public static void main(String args[]){

	//Testing for sortOfReverse()

	//int [] a = {1,1,1,1};
	//int [] a = {-1,-2,-3,-4};
	//int [] a = {};
	//int[] a = null;
	//int[] a = {5,2,1,3,4};
/*
	for(int i=0; i < a.length; i++) {
		System.out.print(sortOfReverse(a)[i] + " ");
	}

 */
	System.out.println("");
	//Testing for cutString()

	//String s = "abraham";
	//String s = "bacon";
	//String s = "";
	//String s = "a";
	//String s = null;
	//System.out.println(cutString(s));

}
	/* Method sortOfReverse:
	 * Given a `1D array of integers, sortOfReverse reverses the order
	 * of the elements in array that are in increasing order.
	 * For instance: [1,2,3,4] remains unchanged because 1 < 4 and 2 < 3
	 * Similarly, [4,1,2,3] because [3,1,2,4] because 4 > 3 (hence they are swapped)
	 * but 1 < 2 (hence they remain in place)
	 */
	public static int[] sortOfReverse(int[] array) {
		int temp; 
		for(int i =0; i < array.length/2; i++) {
			if (array[array.length-1-i] < array[i]) {
				temp = array[array.length-1-i];
				array[array.length-1-i] = array[i];
				array[i] = temp;
			}
		}    
		return array;    
	}
	
	/* Method cutString:
	 * Given a string, return a version without the first 2 chars. 
	 * Except keep the first char if it is 'a' and keep the second 
	 * char if it is 'b'. 
	 * The string may be any length.  
	 */
    public static String cutString(String s) {
    	if(s.charAt(0) == 'a')
	       	if(s.charAt(1) == 'b')
	       		return s;
	       	else 
	       		return s.charAt(0) + s.substring(2);
	     else if (s.charAt(1) == 'b')
	    	 return s.substring(1);
	     else 
	    	 return s.substring(2);   
    }

}
