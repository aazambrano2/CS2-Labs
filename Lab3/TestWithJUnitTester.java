import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class TestWithJUnitTester {

    /*
     * A = {10,10,10,10,10}
     * A = {10, 10, 1, 10, 10}
     * A = { }
     * A = null
     * A = {10}
     */
    @Test
    public void testWithout10_1(){
        TestWithJUnit test = new TestWithJUnit();
        int[] A = {10,10,10,10,10};
        int[] expected = {0,0,0,0,0};
        assertArrayEquals(expected, test.withoutTen(A));
    }
    @Test
    public void testWithout10_2(){
        TestWithJUnit test = new TestWithJUnit();
        int[] A = {10, 10, 1, 10, 10};
        int[] expected = {1,0,0,0,0};
        assertArrayEquals(expected, test.withoutTen(A));
    }
    @Test
    public void testWithout10_3(){
        TestWithJUnit test = new TestWithJUnit();
        int[] A = { };
        int[] expected = {};
        assertArrayEquals(expected, test.withoutTen(A));
    }
    @Test
    public void testWithout10_4(){
        TestWithJUnit test = new TestWithJUnit();
        int[] A = null;
        assertNull(test.withoutTen(A));
    }
    @Test
    public void testWithout10_5(){
        TestWithJUnit test = new TestWithJUnit();
        int[] A = {10};
        int[] expected = {0};
        assertArrayEquals(expected, test.withoutTen(A));
    }
    /*
     * n = 1
     * n = 0
     * n = -1
     * n = Interger.MAX_Value
     * n = Integer.MIN_Value
     */
    @Test
    public void testBigArray_1(){
        TestWithJUnit test = new TestWithJUnit();
        int n = 1;
        int[] expected = {1};
        assertArrayEquals(expected,test.bigArray(n));
    }
    @Test
    public void testBigArray_2(){
        TestWithJUnit test = new TestWithJUnit();
        int n = 0;
        int[] expected = {};
        assertArrayEquals(expected,test.bigArray(n));
    }
    @Test
    public void testBigArray_3(){
        TestWithJUnit test = new TestWithJUnit();
        int n = -1;
        int[] expected = {};
        assertArrayEquals(expected,test.bigArray(n));
    }
    @Test
    public void testBigArray_4(){
        TestWithJUnit test = new TestWithJUnit();
        int n = Integer.MAX_VALUE;
        int [] expected = new  int[n*(n+1)/2];
        int sizeofExpected = expected.length;
        assertSame(test.bigArray(sizeofExpected),test.bigArray(n));
    }
    @Test
    public void testBigArray_5(){
        TestWithJUnit test = new TestWithJUnit();
        int n = Integer.MIN_VALUE;
        int[] expected = {};
        assertArrayEquals(expected,test.bigArray(n));
    }






}
