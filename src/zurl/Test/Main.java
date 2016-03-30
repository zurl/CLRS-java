    package Zurl.Test;

    import java.util.Scanner;

    /**
     * Created by zcy on 3/28/2016.
     */
    public class Main {
        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            int a = in.nextInt();
            int b = in.nextInt();
            int sum = a+b;
            if(sum<0){
                System.out.print("-");
                sum = -sum;
            }
            if(sum<=999){
                System.out.println(sum);
            }else{
                String ret = "";int flag = 0;
                while(sum > 0){
                    if(flag == 0)flag = 1;
                    else ret = "," + ret;
                    ret = Integer.toString(sum%1000) + ret;
                    sum /= 1000;
                }
                System.out.println(ret);
            }
        }
    }
