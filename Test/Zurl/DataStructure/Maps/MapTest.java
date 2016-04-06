package Zurl.DataStructure.Maps;

import Zurl.TestConfig;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zcy on 4/5/2016.
 */
public abstract class MapTest {
    Map<String,String> data;
    String[] saved;
    int datasize = TestConfig.MapTestSize;

    MapTest(){}

    protected void baseSetup(){
        data.set("hello","furry");
        saved = new String[datasize +10];
        for(int i = 1 ;i<=datasize ;i++){
            String tmp =getRandomString();
            data.set(tmp,getRandomString());
            saved[i] = tmp;
        }
    }

    @Before
    public abstract void setUp() throws Exception;

    @Test
    public void testDelete() throws Exception {
        data = new BinarySearchTree<>();
        data.set("hi","ljk");
        data.set("nihao","ljkaa");
        data.set("fu","ck");
        data.set("cao","nima");
        data.set("shaonian","juhuaxiang");
        data.set("nia","a");
        data.set("fz","pa");
        data.delete("hi");
        data.delete("fu");
        data.delete("shaonian");
        data.delete("hi");
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
