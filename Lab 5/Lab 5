/**
 * Student: Aaron Zambrano
 * Professor: Martine Ceberio
 */

import java.util.Random;
public class Island {

    /**
     * Compputes the volume of water in an array of heights.
     * @param islands array
     * @return volume of the water that holds the islands
     */
    public static int islandWater(int[] islands){
        int volume = 0;
        int j ,k;
        for(int i = 0; i < islands.length; i++){
            int maxFromTheLeft = 0;
            int maxFromTheRight = 0;
            for(j = 0; j <= i; j++ ){ //searching for the maximum starting from the left of the array
                maxFromTheLeft = Math.max(islands[j],maxFromTheLeft);
            }
            for(k = islands.length - 1; k >= i; k--) {//searching for the maximum starting from the right of the array
                maxFromTheRight = Math.max(islands[k], maxFromTheRight);
            }
            volume += Math.min(maxFromTheLeft,maxFromTheRight) - islands[i]; //finding the minimum between maximums and getting the difference from height
        }
        return volume;
    }

    /**
     * Generates an array with random values for each element given the size of the input
     * @param  size
     * @return a randomly size array with randomly values at each element
     */
    public static int[] randomArray(int size){
        Random random = new Random();

        int [] islands = new int[size];
        for(int i  = 0; i < islands.length; i++){
            islands[i] = random.nextInt(); // A random value assigned for each element of the array.
        }
        return islands;
    }

    public static void main(String[] args){
        long start, end = 0, diff = 0;;
        long currentTestTime;
        //run n tests with n sizes
        int TESTS = 100; //tested with 100,1000,10000
        int size = 100; // tested with 100,1000,10000
        long max = 0, min = Integer.MAX_VALUE;

        for(int i=0; i < TESTS; i++){
            //start timer
            start = System.currentTimeMillis();
            //Calling islandWater() with the argument from the new random array given from randomArray()
            islandWater(randomArray(size));
            //end timer
            end = System.currentTimeMillis();
            currentTestTime = end - start;
            // The minimum time out of the number of tests
            if(currentTestTime < min){
                min = currentTestTime;
            }
            // The maximum time out of the number of tests
            if(currentTestTime > max){
                max = currentTestTime;
            }
            diff +=  currentTestTime;
        }
        System.out.println("Average: " + (double) diff/TESTS); //average time
        System.out.println("Min Time: " + (double) min + " Max Time: "+ (double) max);
    }
}
