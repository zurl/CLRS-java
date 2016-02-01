package Zurl.Search;

/**
 * Created by furry on 1/29/2016.
 */
public class LinearSearch {
    public static int search(int[] a,int x){
        for(int i=0;i<=a.length-1;i++){
            if(a[i] == x)
                return i;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] test = {9,8,7,6,5,4,3};
        System.out.println(search(test,7));
    }
}
