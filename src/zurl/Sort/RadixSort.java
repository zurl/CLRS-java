package Zurl.Sort;

/**
 * Created by furry on 2/4/2016.
 */
public class RadixSort {
    public static int getPosNum(int x,int d){
        while(d != 0){
            x/=10;
            d--;
        }
        return x%10;

    }
    public static boolean rSort(int[] a,int d){
        int[][] bucket = new int[10][a.length];
        int[] now = new int[10];
        for(int x : a){
            int t = getPosNum(x,d);
            bucket[t][now[t]++] = x;
        }
        int pos = -1,flag = 0;
        for(int i=0;i<=9;i++){
            if(now[i]!=0)flag ++;
            for(int j=0;j<now[i];j++){
                a[++pos] = bucket[i][j];
            }
        }
        return flag > 1;
    }
    public static void sort(int[] a){
        int t = 0;
        while(rSort(a,t))t++;
    }

    public static void main(String[] args) {
        int[] test = new int[2000];
        for (int i = 0; i < test.length; i++)
            test[i] = (int) (1 + Math.random() * (1000 - 1 + 1));
        for (int x : test)
            System.out.print(x + " ");
        System.out.println();
        sort(test);
        for (int x : test)
            System.out.print(x + " ");
        System.out.println();
    }
}
