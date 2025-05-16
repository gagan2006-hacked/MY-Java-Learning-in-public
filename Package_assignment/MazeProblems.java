package com.Package_assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MazeProblems {
    public static void main(String[] args) {
        boolean [][]arr={
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        System.out.println(arr.length);
//        System.out.println(manToTarget(0,3,3));
        /*int cou=0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                arr[i][j]=cou+1;
                cou+=1;
            }

        }
        for (int[] ele :arr){
            System.out.println(ele[0]);
        }
        System.out.println(arr.length);*/
//        manToTargetPrintPath("",3,3);
//        manToTargetWithDiagonalPrintPath("",3,3);
//        System.out.println(manToTargetGetListOfPath("",3,3));
        manToTargetWithDiagonalPrintPathAndObstacles(arr,"",0,0);
    }
    public static int manToTarget(int ways,int row,int col){
        if (row==1 && col==1){
            return 1;
        }int way1=0;
        int way2=0;
        if (row>1){
            way1=manToTarget(ways,row-1,col);
        }
        if (col>1){
            way2=manToTarget(ways,row,col-1);
        }
        ways=way1+way2;
        return ways;
    }
    public static void manToTargetPrintPath(String path,int row,int col){
        if (row==1 && col==1){
            System.out.println(path);
            return ;
        }
        if (row>1){
            manToTargetPrintPath(path+"Down ",row-1,col);
        }
        if (col>1){
            manToTargetPrintPath(path+"Right ",row,col-1);
        }
    }
    public static List<String> manToTargetGetListOfPath(String path, int row, int col){
        if (row==1 && col==1){
            List<String>list=new ArrayList<>();
            list.add(path);
            return list;
        }
        List<String>list=new ArrayList<>();
        if (row>1){
            list.addAll(manToTargetGetListOfPath(path+"Down ",row-1,col));
        }
        if (col>1){
           list.addAll(manToTargetGetListOfPath(path+"Right ",row,col-1));
        }
        return list;
    }
    public static void manToTargetWithDiagonalPrintPath(String path,int row,int col){
        if (row==1 && col==1){
            System.out.println(path);
            return ;
        }
        if (row>1){
            manToTargetWithDiagonalPrintPath(path+"Down ",row-1,col);
        }
        if (row>1 && col>1){
            manToTargetWithDiagonalPrintPath(path+"Diagonal ",row-1,col-1);
        }
        if (col>1){
            manToTargetWithDiagonalPrintPath(path+"Right ",row,col-1);
        }
    }
    public static void manToTargetWithDiagonalPrintPathAndObstacles(boolean[][]arr,String path,int row,int col){
        if (row==arr.length-1 && col==arr[0].length-1){
            System.out.println(path);
            return ;
        }
        if (arr[row][col]==false){
            return;
        }
        if (row<arr.length-1){
            manToTargetWithDiagonalPrintPathAndObstacles(arr,path+"Down ",row+1,col);
        }
        if (row<arr.length-1 && col<arr[row].length-1){
            manToTargetWithDiagonalPrintPathAndObstacles(arr,path+"Diagonal ",row+1,col+1);
        }
        if (col<arr[row].length-1){
            manToTargetWithDiagonalPrintPathAndObstacles(arr,path+"Right ",row,col+1);
        }
    }
}
