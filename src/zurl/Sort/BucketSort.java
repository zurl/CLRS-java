package Zurl.Sort;

/**
 * Created by furry on 2/4/2016.
 */
public class BucketSort {
    public static void bSort(double[] a,int bucketCount) {
        double[][] b = new double[bucketCount][a.length];
        int[] now = new int[bucketCount];
        //divide
        for(double x : a){
            int t = (int)(bucketCount * x);
            b[t][now[t]++] = x;
        }
        //sort the bucket
        for(int i=0;i<bucketCount;i++)
            if(now[i]!=0)
            Zurl.Sort.MergeSort.mSort(b[i],0,now[i]-1);
        //merge
        int t=-1;
        for(int i=0;i<bucketCount;i++)   {
            for(int j=0;j<now[i];j++){
                a[++t] = b[i][j];
            }
        }
    }
    public static void sort(double[] a){
        bSort(a,100);
    }
    public static void main(String[] args){
        double[] test = new double[500];
        for (int i = 0; i < test.length; i++)
            test[i] = Math.random();
        for (double x : test)
            System.out.print(x + " ");
        System.out.println();
        sort(test);
        for (double x : test)
            System.out.print(x + " ");
        System.out.println();


    }
}
