package com.Leetcode;

import java.util.Arrays;
import java.util.List;


public class LC48 {
     /*public static void rotate(int[][] matrix) {
         rotateHelper(matrix,0);
         return;
    }
    public static void rotateHelper(int[][] matrix,int rw) {
         if (rw>=matrix.length)return;
         int col=matrix[rw].length-rw-1;
        List<Integer> list = Arrays.stream(matrix[rw]).boxed().toList();
        rotateHelper(matrix,rw+1);
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col]=list.get(i);
        }
    }*/
     public static void rotate(int[][] matrix) {
         for (int i = 1; i < matrix.length; i++) {
             for (int j = 0; j < i; j++) {
                 int temp = matrix[i][j];
                 matrix[i][j] = matrix[j][i];
                 matrix[j][i] = temp;
             }
         }


         for(int i = 0; i<matrix.length;i++) {
             int stCol=0,endCol=matrix.length-1;
             while(stCol<endCol){
                 int temp=matrix[i][stCol];
                 matrix[i][stCol]=matrix[i][endCol];
                 matrix[i][endCol]=temp;
                 stCol++;
                 endCol--;
             }
         }
     }

    public static void main(String[] args) {
         int ma[][]=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
         rotate(ma);
         for (int ro[]:ma){
             System.out.println(Arrays.toString(ro));
         }
    }
}