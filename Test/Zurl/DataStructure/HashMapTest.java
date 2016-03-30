package Zurl.DataStructure;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by zcy on 3/30/2016.
 */
public class HashMapTest {


    HashMap<String,String> data = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        data.set("0","1");
        data.set("orz","wzh");
        data.set("zcy","sb");
    }

    @Test
    public void testGet() throws Exception {
        assertEquals(data.get("0"),"1");
        assertEquals(data.get("orz"),"wzh");
        assertEquals(data.get("zcy"),"sb");
        data.set("0","12");
        data.set("orz","wzh2");
        data.set("zcy","sb2");
        assertEquals(data.get("0"),"12");
        assertEquals(data.get("orz"),"wzh2");
        assertEquals(data.get("zcy"),"sb2");
    }
}