package Zurl.Search;

/**
 * Created by furry on 1/31/2016.
 */
public class RandomSearch {
    public static int search(int[] a,int x){
        //get random seq
        int[] b = new int[a.length];
        for(int i = 0;i<a.length;i++)
            b[i]=i;
        Zurl.Random.Permute.permute(b);
        for(int i=0;i<=a.length-1;i++){
            if(a[b[i]] == x)
                return b[i];
        }
        return -1;
    }
    public static void main(String[] args){
        int[] test = {9,8,7,6,5,4,3};
        System.out.println(search(test,7));
    }
}
