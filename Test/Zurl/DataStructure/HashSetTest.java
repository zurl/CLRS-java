package Zurl.DataStructure;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zcy on 3/31/2016.
 */
public class HashSetTest
{

    HashSet<String> data = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        data.set("0");
        data.set("orz");
        data.set("zcy");
    }

    @Test
    public void testSet() throws Exception {
        assertEquals(data.hasKey("0"),true);
        assertEquals(data.hasKey("orz"),true);
        assertEquals(data.hasKey("zcy"),true);
    }
}