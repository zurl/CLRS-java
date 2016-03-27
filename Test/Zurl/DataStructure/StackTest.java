package Zurl.DataStructure;

import Zurl.Common.Generator;
import Zurl.Common.IntegerGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zcy on 3/26/2016.
 */
public class StackTest {
    private Stack stack = new Stack();
    private java.util.Stack<Integer> result = new java.util.Stack<>();
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testPush() throws Exception {
        Generator<Integer> gen = new IntegerGenerator();
        for(int i=1 ; i<= 100;i++){
            int x = gen.next();
            stack.push(x);
            result.push(x);
            assertEquals(stack.top(),(int)result.peek());
        }
    }
}