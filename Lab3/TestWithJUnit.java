public class TestWithJUnit {

	/* Method withoutTen:
	 * Return a version of the given array where all 
	 * the 10's have been removed. 
	 * The remaining elements should shift left 
	 * towards the start of the array as needed, 
	 * and the empty spaces a the end of the array 
	 * should be 0. 
	 * So {1, 10, 10, 2} yields {1, 2, 0, 0}. 
	 * {1, 10, 10, 2, 10, 3, 10} yields {1, 2, 3, 0, 0, 0, 0}.
	 */
	public int[] withoutTen(int[] A) {
		int[] result = new int[A.length];
		int index = 0;
		
		for (int i = 0; i < A.length; i++) {
			if (A[i] != 10) { 
				result[index] = A[i];
				index++;
			}
		}
		for (int i = index; i < result.length; i++)
			result[i] = 0;
		
		return result;
	}
	
	/* Method bigArray:
	 * Given an integer n, bigArray creates and returns a 1D array
	 * that contains {1, 1, 2, 1, 2, 3, 1, 2, 3, 4, 1, 2, ... n}
	 * For instance, bigArray(4) = {1, 1, 2, 1, 2, 3, 1, 2, 3, 4}
	 * bigArray(2) = {1, 1, 2}
	 */
	public  int[] bigArray(int n) {
		int[] result = new int[n*(n+1)/2];
		int index = 0;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				result[index] = j;
				index++;
			}
		}
		return result;
	}
		
}
