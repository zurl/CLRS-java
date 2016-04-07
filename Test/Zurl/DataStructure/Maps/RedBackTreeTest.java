package Zurl.DataStructure.Maps;

import static org.junit.Assert.*;

/**
 * Created by zcy on 4/7/2016.
 */
public class RedBackTreeTest
    extends MapTest {
    @Override
    public void setUp() throws Exception {
        data = new RedBackTree<>();
        baseSetup();
    }
}
