import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class QueueTest.
 *
 * @author  Oyunomin Munkhkhurel
 * @version 3/11/2018
 */
public class QueueTest {
    /**
     * Default constructor for test class QueueTest
     */
    public QueueTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testQueueAddAndSize() {
        Queue<Integer> test = new Queue<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        assertEquals(new Integer(1), test.get(0));
        assertEquals(new Integer(2), test.get(1));
        assertEquals(new Integer(3), test.get(2));
        assertEquals(3, test.size());
    }
    
    @Test
    public void testQueueRemoveSizeIsEmpty() {
        Queue<Integer> test = new Queue<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        
        test.remove();
        
        assertEquals(2, test.size());
        assertEquals(new Integer(2), test.get(0));
        assertEquals(new Integer(3), test.get(1));
    }
    
    @Test
    public void testQueuePeek() {
        Queue<Integer> test = new Queue<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        assertEquals(new Integer(1), test.peek());
        test.remove();
        assertEquals(new Integer(2), test.peek());
    }
    
    @Test (expected = IllegalArgumentException.class) 
    public void testPreCond() {
        Queue<Integer> test = new Queue<Integer>();
        test.add(null);
    }
}
