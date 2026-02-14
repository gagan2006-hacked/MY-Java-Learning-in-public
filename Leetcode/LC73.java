package com.Leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class LC73 {
    public static void setZeroes(int[][] matrix) {
        HashSet<Integer>rows=new HashSet<>();
        HashSet<Integer>columns=new HashSet<>();
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j <matrix[i].length; j++) {
                if (matrix[i][j]==0){
                    if (!rows.contains(i)){
                     rows.add(i);
                    }
                    if (!columns.contains(j)){
                        columns.add(j);
                    }
                }
            }
        }
        for (Integer i:rows){
            Arrays.fill(matrix[i], 0);
        }
        for (Integer i:columns){
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i]=0;
            }
        }
    }

    public static void main(String[] args) {
        int [][]matrix=new int[][]{
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        setZeroes(matrix);
        for (int []r:matrix){
            System.out.println(Arrays.toString(r));
        }
    }
}
