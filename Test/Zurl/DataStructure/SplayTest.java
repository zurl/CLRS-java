package Zurl.DataStructure;

import Zurl.TestConfig;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zcy on 4/4/2016.
 */
public class SplayTest {

    Splay<String,String> data = new Splay<>();
    String[] saved;
    int datasize = TestConfig.MapTestSize;
    @Before
    public void setUp() throws Exception {
        data.set("hello","furry");
        saved = new String[datasize +10];
        for(int i = 1 ;i<=datasize ;i++){
            String tmp =getRandomString();
            data.set(tmp,getRandomString());
            saved[i] = tmp;
        }
    }


    private String getRandomString(){
        int len = 20 + (int)(Math.random()*100);
        String str = "";
        for(int i = 1  ; i<=len;i++){
            str += (char)('a' + ((int)(Math.random()*1000))%26 );
        }
        return str;
    }

    @Test
    public void testSet() throws Exception {
        for(int i = 1 ;i<=datasize ;i++){
            data.set(getRandomString(),getRandomString());
        }

    }

    @Test
    public void testGet() throws Exception {
        for(int i = 1 ;i<=datasize ;i++){
            data.get(saved[i]);
        }
    }
}