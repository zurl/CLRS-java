package Zurl.Common;

import Zurl.Main;

/**
 * Created by zcy on 3/26/2016.
 */

public class IntegerGenerator
        implements  Generator<Integer>{
    private int now = 0;
    public Integer next(){
        now -= 50 ;
        return now + (int)(Math.random() * 100);
    }
}