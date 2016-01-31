package zurl.Random;

/**
 * Created by furry on 1/31/2016.
 */
public class Permute {
    public static void permute(int[] a){
        //place in random
        for(int i=0;i<=a.length-1;i++){
            int x = (int)((a.length-i-2)*Math.random()+i+1);
            int t = a[i];
            a[i] = a[x];
            a[x]=t;
        }
    }
    public static void main(String[] args){
        //o(n)
        int[] test = {9,8,7,6,5,4,3};
        permute(test);
        for(int x : test)
            System.out.println(x);
    }
}
