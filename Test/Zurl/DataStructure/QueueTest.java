package Zurl.DataStructure;

import Zurl.Common.Generator;
import Zurl.Common.IntegerGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zcy on 3/27/2016.
 */
public class QueueTest {
    private Queue queue = new Queue();
    private java.util.ArrayDeque<Integer> result = new java.util.ArrayDeque<>();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testFront() throws Exception {
        Generator<Integer> gen = new IntegerGenerator();
        for(int i=1 ; i<= 100;i++){
            int x = gen.next();
            queue.push(x);
            result.add(x);
            assertEquals(queue.front(),(int)result.peek());
        }
    }
}