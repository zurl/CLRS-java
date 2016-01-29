package zurl.Sort;

/**
 * Created by furry on 1/29/2016.
 */
public class InsertSort {
    public static void sort(int[] a){
        for(int i=1;i<=a.length-1;i++){
            //Save the key value
            int key = a[i],j;
            //Find the insert pos
            for(j=i-1;j>=0 && a[j]>key;j--){
                a[j+1] = a[j];
            }
            //insert
            a[j+1]=key;
        }
    }
    public static void main(String[] args){
        int[] test = {9,8,7,6,5,4,3};
        sort(test);
        for(int x : test)
            System.out.println(x);
    }
}
