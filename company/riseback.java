package com.company;
import java.util.Scanner;
public class riseback {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number till to be add");
//        int d= sc.nextInt();
//        switch (d){
//            case 1:
//                System.out.println("monday");
//                break;
//            case 2:
//                System.out.println("tuesday");
//                break;
//            case 3:
//                System.out.println("wednesday");
//                break;
//            case 4:
//                System.out.println("thursday");
//                break;
//            case 5:
//                System.out.println("friday");
//                break;
//            case 6:
//                System.out.println("satday");
//                break;
//            case 7:
//                System.out.println("sunday");
//                break;
//            default:
//                System.out.println("in vaild chocie");
//
//        }
//        String url= sc.nextLine();
//        if (url.endsWith("com")){
//            System.out.println("its a commerical website");
//        }else if(url.endsWith("org")){
//            System.out.println("its a organization website");
//        }else {
//            System.out.println("its a indian website");
//
//        int n= sc.nextInt();
//        for (int i=n;i>0;i--){
//           for (int k=0;k<i;k++){
//               System.out.print("*");
//           }
//            System.out.print("\n");
//        }

    /*    int ar = sc.nextInt();
        int sum=0;
        int i=1;
        while(i<=ar){
            sum=sum+(i);
            i++;
        }
        System.out.println("sum of the number till "+ar+" are "+sum);*/
        print_1to_n(9);
    }
    static void print_1to_n(int n){
        if (n==0)return;

        print_1to_n(n-1);
        System.out.println(n);

    }
}


