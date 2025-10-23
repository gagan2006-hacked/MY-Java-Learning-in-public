package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.company.Assignments.fac;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("enter the number of rows");
        int rows=in.nextInt();
//        pascalTrianglePrint(rows);
//        System.out.println(getPascalsTriangleRow(rows-1));
//        System.out.println(sumOfPascalrows(rows));
//        System.out.println(sumOfPascalNthRow(rows));

    }
    public static long sumOfPascalNthRow(int n){
        return 1L <<(n-1);
    }

//    not Optimaiazited do not try to use if rows is big than 21
    public static long sumOfPascalrows(int i){
        long sum=0;
        String out="";
        i-=1;
        for (int j = 0; j <=i ; j++) {
            sum+=valueOfPascal(i,j);
            out+=" "+valueOfPascal(i,j);
            System.out.print(valueOfPascal(i,j)+" ");

        }
//        System.out.println(out);

        return sum;
    }

    private static void pascalTrianglePrint(int rows) {
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <=i ; j++) {
                System.out.print(valueOfPascal(i,j)+" ");
            }
            System.out.println();

        }
    }

    private static long valueOfPascal(int n, int r) {
        long value=1;
     value=fac(n)/(fac(n-r)*fac(r));
        return value;
    }
    public static List<Integer> getPascalsTriangleRow(int n) {
        List<Integer> row = new ArrayList<>();
        row.add(1); // First element is always 1

        for (int k = 1; k <= n; k++) {
            row.add((int)((long) row.get(k - 1) * (n - k + 1) / k)); // Compute next element
        }

        return row;
    }
}
