package Zurl.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.Exchanger;

import Zurl.Sort.*;

/**
 * Created by furry on 2/3/2016.
 */
public class SortPerformance {
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        Date dt = new Date();
        long t1,t2;
        final int SIZE = 5000000;
        System.out.println("Sort Performance Test");
        String[] testMethod = {"ShellSort","QuickSort","CountSort","MergeSort","HeapSort","MultiSort","SuperSort","RadixSort"};
        //generator
        int[] test = new int[SIZE];
        for (int i = 0; i < test.length; i++)
            test[i] = (int) (1 + Math.random() * (1000 - 1 + 1));
        for(String x : testMethod){
            try{
                int [] a = new int[SIZE];
                System.arraycopy(test,0,a,0,test.length);
                Class cl = Class.forName("Zurl.Sort." + x);
                Method md = cl.getDeclaredMethod("sort",int[].class);
                t1 = System.nanoTime();
                md.invoke(cl,a);
                t2 = System.nanoTime();
                long ans = t2 - t1;
                System.out.println(x + " : " + ans/10000 + " ms");
            }catch(Exception e){
                System.out.println("Error Class Not Found");
            }
        }
        //System
        int [] a = new int[SIZE];
        System.arraycopy(test,0,a,0,test.length);
        t1 = System.nanoTime();
        Arrays.sort(a);
        t2 = System.nanoTime();
        long ans = t2 - t1;
        System.out.println("System " + " : " + ans/10000 + " ms");
    }
}
