package Zurl.DataStructure;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by zcy on 3/27/2016.
 */
public class LinkedListTest {

    LinkedList data = new LinkedList();
    int[] result;
    @Before
    public void setUp() throws Exception {
        int x = (int)(Math.random()*100);
        result = new int[x];
        for(int i=0;i<=x-1;i++) {
            int e = (int) (Math.random() * 1000);
            data.push(e);
            result[i] = e;
        }

    }

    @Test
    public void testSort() throws Exception {
        data.sort();
        Arrays.sort(result);
        assertArrayEquals(data.toArray(),result);
    }

    @Test
    public void testInverse() throws Exception {
        assertArrayEquals(data.inverse().toArray(),result);
    }
}