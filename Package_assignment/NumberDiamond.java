package com.Package_assignment;

public class NumberDiamond {
    public static void main(String[] args) {
        int n = 4;

        // Upper half
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print(j);
            for (int j = i - 1; j >= 1; j--)
                System.out.print(j);
            System.out.println();
        }

        // ❌ Lower half - logic error
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i; j < n; j++) // wrong condition
            {
                System.out.print("");
            }
            for (int j = 1; j <= i; j++)
            {
                System.out.print(j);
            }
            for (int j = i - 1; j >= 1; j--)
            {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}


