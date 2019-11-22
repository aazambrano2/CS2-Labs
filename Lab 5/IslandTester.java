/**
 * Student: Aaron Zambrano
 * Professor: Martine Ceberio
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IslandTester {
    /**
     *Testing to see how the method will behave if an array is in sorting order.
     * Aims to see if the water volume will be zero because of the slope of the island heights
     * @result: Method should return 0 for the volume of water.
     */
    @Test
    public void islandWaterTest_1(){
        int[] test = {1,2,3,4,5};
        assertEquals(0, Island.islandWater(test));
    }
    /**
     *Testing to see how the method will behave if an array has the value of 0 in each element
     * Aims to see if the water volume will be 0 as there is nothing to contain water
     * @result: Method should return 0 for the volume of water.
     */
    @Test
    public void islandWaterTest_2(){
        int[] test = {0,0,0,0,0};
        assertEquals(0, Island.islandWater(test));
    }
    /**
     *Testing to see how the method will behave if an array has only one peak.
     * Aims to see if the water volume will be 0 as one peak will run off water in one or both directions.
     * @result: Method should return 0 for the volume of water
     */
    @Test
    public void IslandTest_3(){
        int[] test = {0,0,0,0,1,0,0,0,0};
        assertEquals(0, Island.islandWater(test));
    }
    /**
     *Testing to see how the method will behave if an array has negative values in one element.
     *Aims to see if the water volume is calculated if a height below ground level (height of 0).
     *@result: Method should the volume of water with one negative value in an element in the array
     */
    @Test
    public void IslandTest_4(){
        int [] test = {0,0,-1,0,0,0};
        assertEquals(1, Island.islandWater(test));
    }
    /**
     *Testing to see how the method will behave if an array has negative values in all elements.
     *Aims to see if the water volume will be calculated since it is below ground level (height of 0)
     *@result: Method should return the volume of water
     */
    @Test
    public void IslandTest_5(){
        int [] test = {-1,-1,-1,-1,-1,-1};
        assertEquals(6, Island.islandWater(test));
    }
}