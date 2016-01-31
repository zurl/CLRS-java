package zurl.Math;

/**
 * Created by furry on 1/31/2016.
 */
public class Martix {
    int[][] val;
    int n,m;
    public Martix(int _n){
        val = new int[_n][_n];
        n=_n;m=_n;
    }
    public Martix(int _n,int _m){
        val = new int[_n][_m];
        n=_n;m=_m;
    }
    public void print(){
        for(int i=0;i<=n-1;i++){
            for(int j=0;j<=n-1;j++){
                System.out.print(val[i][j] + " ");
            }
            System.out.println();
        }
    }
}
