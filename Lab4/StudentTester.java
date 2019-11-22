/**
 *
 * @author mceberio
 * @student Aaron Zambrano <-- FILL IN HERE WITH YOUR NAME
 *
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class StudentTester {
    //***average() Test Suite

    /**
    *Testing to see how the method will behave when a student’s grades array is empty
    *Aims to see if the method returns an average value of an empty array
    * @result: a NaN should return by the method.
    */
    @Test
    public void averageTest_1(){
        int [] expected = {};
        Student test = new Student("S","M",expected);
        test.setGrades(expected);
        assertEquals(Double.NaN, test.average());
    }
    /**
     *Testing to see how the method will behave when a student only has one grade.
     *Aims to see if the method returns an average value of an a array with a single element
     * @result: the value of the single element should return
     */
    @Test
    public void averageTest_2(){
        int [] expected = {100};
        Student test = new Student("S","M",expected);
        test.setGrades(expected);
        assertEquals(100, test.average());
    }
    /**
     *Testing to see how the method will behave when all of the student's grades are 0's
     *Aims to see if the method returns an average value of an an array with all elements are 0's.
     * @result: An average of 0.0 should return
     */
    @Test
    public void averageTest_3(){
        int[] expected = {0,0,0,0,0,0};
        Student test = new Student("S","M",expected);
        test.setGrades(expected);
        assertEquals(0,test.average());
    }

    //***averageW() Test Suite

    /**
     *Testing to see how the method will behave when all of the student's grades array is empty
     *Aims to see if the method returns a weighted average value of an an array with all elements are 0's.
     * @result: A NaN should return by the method
     */
    @Test
    public void averageWTest_1(){
        int [] expected = {};
        Student test = new Student("S","M",expected);
        int [] weights = {10,20,10,20,10,20,10};
        test.setGrades(expected);
        assertEquals(Double.NaN, test.averageW(weights));

    }
    /**
     *Testing to see how the method will behave when all of the student's grades are 0's
     *Aims to see if the method returns an average value of an an array with all elements are 0's.
     * @result: The single grade divided by corresponding weight should return
     */
    @Test
    public void averageWTest_2(){
        int [] expected = {100};
        Student test = new Student("S","M",expected);
        int [] weights = {10,20,10,20,10,20,10};
        test.setGrades(expected);
        assertEquals(100, test.averageW(weights));

    }
    /**
     *Testing to see how the method will behave when all of the student's grades are 0's
     *Aims to see if the method returns an average value of an an array with all elements are 0's.
     * @result: A weighted average of 0.0 should return
     */
    @Test
    public void averageWTest_3(){
        int [] expected = {0,0,0,0,0,0};
        Student test = new Student("S","M",expected);
        int [] weights = {10,20,10,20,10,20,10};
        test.setGrades(expected);
        assertEquals(0, test.averageW(weights));
    }
}