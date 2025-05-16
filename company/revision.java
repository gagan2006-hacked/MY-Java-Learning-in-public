package com.company;
import java.util.Scanner;
public class revision {
   //static int mu(int a){
//        for (int i=a;i>=0;i--){
//            for (int j=0;j<i;j++){
//                System.out.print("*");
//            }
//            System.out.println(" ");
//
//        }
//        return 0;
   // }
//    static int sum1(int q){
//        if(q==0){
//            return 0;
//
//        }
//        return q + sum1(q-1);
//    }
//    static int m11(int ...arr){
//        int avg=0;
//        for (int q: arr){
//            avg+=q;
//
//        }avg= avg/arr.length;
//        return avg;
//    }
    static float convert(float a){
        float c;
         c=(9*a/5f)+ 32f;
    return c;
    }
    static float conv(float b)
    {float d;
        d=((b-32)*5)/9;
return d;
    }
    public static void main(String[] args) {
        Scanner st = new Scanner(System.in);
      System.out.println("enter the number for celeius to farenhit 1, for farenhit to celecius 2");
       int n = st.nextInt();
       if (n==1){
           System.out.println("enter the celecius ");
           float r= st.nextFloat();
           float e=convert(r);
           System.out.println("the celecius"+r+" in farenhit is"+e);
       }else if(n==2) {
           System.out.println("enter the farenhit" );
           float r= st.nextFloat();
           float e=conv(r);
           System.out.println("the farenhit "+r+"in celelius is"+e);

       }else {
           System.out.println("invaild choice");
       }

    }}

