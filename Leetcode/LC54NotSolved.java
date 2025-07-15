package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC54NotSolved {

    /*public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length<2){
            List<Integer>list=new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    list.add(matrix[i][j]);
                }
            }
            return list;
        }
        List<Integer>result=new ArrayList<>();
        return pathOfSpiral(matrix,0,0,result);
    }

    public static List<Integer> pathOfSpiral(int[][] matrix, int row, int col,List<Integer> result) {
        if (result.size()==matrix.length*matrix[0].length){
            return result;
        }
//        List<Integer>list=new ArrayList<>();
//        right side moving
        if (matrix[row][col]!=200 && col!=matrix[0].length-1 && row ==0){
            int val=matrix[row][col];
            result.add(matrix[row][col]);
            matrix[row][col]=200;
            pathOfSpiral(matrix,row,col+1,result);
            matrix[row][col]=val;
            return result;
        }
//        down side moving
        else if (matrix[row][col]!=200 && row!= matrix.length-1 && col==matrix[0].length-1){
            int val=matrix[row][col];
            result.add(matrix[row][col]);
            matrix[row][col]=200;
            pathOfSpiral(matrix,row+1,col,result);
            matrix[row][col]=val;
            return result;
        }
//        left side moving
        else if (matrix[row][col]!=200 && col!=0 && row!=0) {
            int val=matrix[row][col];
            result.add(matrix[row][col]);
            matrix[row][col]=200;
            pathOfSpiral(matrix,row,col-1,result);
            matrix[row][col]=val;
            return result;
        }
        // upside
        else if (matrix[row][col]!=200 && col == 0 && row!=0) {
            int val=matrix[row][col];
            result.add(matrix[row][col]);
            matrix[row][col]=200;
            pathOfSpiral(matrix,row-1,col,result);
            matrix[row][col]=val;
            return result;
        } else if () {
            
        }
        return result;
    }*/
    public  static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) return result;

        int top = 0;
        int bottom = matrix.length - 1;         // m - 1
        int left = 0;
        int right = matrix[0].length - 1;       // n - 1

        while (top <= bottom && left <= right) {
            // Traverse from Left to Right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse Downwards
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Traverse from Right to Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse Upwards
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int [][]arr=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(arr));
    }
}
