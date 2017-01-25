package ua.edu.ucu;

import ua.edu.ucu.stream.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author andrii
 */

public class StreamAppTest {

    private IntStream intStream;

    @Before
    public void init() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
    }

    @Test
    public void testStreamOperations() {
        System.out.println("streamOperations");
        int expResult = 42;
        int result = StreamApp.streamOperations(intStream);
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamToArray() {
        System.out.println("streamToArray");
        int[] expResult = {-1, 0, 1, 2, 3};
        int[] result = StreamApp.streamToArray(intStream);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testStreamForEach() {
        System.out.println("streamForEach");
        String expResult = "-10123";
        String result = StreamApp.streamForEach(intStream);
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamAverage() {
        System.out.println("streamAverage");
        double expResult = 1;
        double result = intStream.average();
        assertEquals(expResult, result, 0.00001);
    }

    @Test
    public void testStreamMax() {
        System.out.println("streamMax");
        int expResult = 3;
        int result = intStream.max();
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamMin() {
        System.out.println("streamMin");
        int expResult = -1;
        int result = intStream.min();
        assertEquals(expResult, result);
    }
    @Test
    public void testStreamCount() {
        System.out.println("streamCount");
        long expResult = 5;
        long result = intStream.count();
        assertEquals(expResult, result);

    }


}
