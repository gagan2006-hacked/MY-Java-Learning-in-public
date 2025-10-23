package com.company;

import java.util.Scanner;

public class Bitwise_op {
//    public static void main(String[] args) {
//        int arr[]={1,6,2,3,2,4,3,5,1,5,4};
//        System.out.println(duplitcate_xor(arr));
//    }
//
//    private static int duplitcate_xor(int[] arr) {
//        int du=0;
//        for (int ele:arr) {
//            du ^= ele;
//        }
//        return du;
//    }
//
//
//
//    // Function to compute binomial coefficient using bitwise operations
//    static int binomialCoeff(int n, int k) {
//        int res = 1;
//        if (k > n - k)
//            k = n - k;  // C(n, k) = C(n, n-k)
//
//        for (int i = 0; i < k; i++) {
//            res = (res * (n - i)) / (i + 1);  // Integer division using bitwise where possible
//        }
//        return res;
//    }
//
//    // Function to print Pascal's Triangle
//    static void printPascal(int rows) {
//        for (int n = 0; n < rows; n++) {
//            // Print spaces for alignment
//            for (int space = 0; space < rows - n; space++) {
//                System.out.print("  ");
//            }
//            // Print the Pascal's Triangle values
//            for (int k = 0; k <= n; k++) {
//                System.out.print(binomialCoeff(n, k) + "   ");
//            }
//            System.out.println();
//        }
//    }



    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
//        int number = in.nextInt();
        String name="gagan";
        System.out.printf(name);

//        System.out.println(power(number, 0b110));
//        System.out.println(power(number));
    }

//    private static boolean power(int number) {
//        int complenumber=number&(number-1);
//
//        if (complenumber==0){
//            return true;
//        }
//        return false;
    public static long power(int base, int exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) { // If the last bit of exp is 1, multiply base to result
                result *= base;
            }
            base *= base; // Square the base
            exp >>= 1; // Right shift exponent (divide by 2)
        }
        return result;
    }





}
