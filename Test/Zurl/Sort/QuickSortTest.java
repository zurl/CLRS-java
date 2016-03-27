package Zurl.Sort;

import Zurl.Common.Generator;
import Zurl.Common.IntegerGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by zcy on 3/26/2016.
 */
public class QuickSortTest {
    private int[] testCase = new int[100];
    private int[] result = new int[100];
    @Before
    public void setUp() throws Exception {
        Generator<Integer> gen = new IntegerGenerator();
        for( int i = 0 ;i<= testCase.length-1;i++){
            testCase[i] = gen.next();
        }
        System.arraycopy(testCase,0,result,0,testCase.length);
        Arrays.sort(result);
    }

    @Test
    public void testSort() throws Exception {
        QuickSort.sort(testCase);
        assertArrayEquals(testCase,result);
    }
}