package Zurl.Sort;

/**
 * Created by furry on 1/29/2016.
 */
public class BubbleSort {
    public static void sort(int[] a){
        for(int i=0;i<=a.length-1;i++){
            int flag=0;
            for(int j=0;j<=a.length-2-i;j++){
                if(a[j]>a[j+1]){
                    flag=1;
                    int t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
            if(flag == 0)break;
        }
    }
    public static void main(String[] args){
        int[] test = {9,8,7,6,5,4,3};
        sort(test);
        for(int x : test)
            System.out.println(x);
    }
}
