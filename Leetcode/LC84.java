package com.Leetcode;

import java.util.Stack;

public class LC84 {
    public static int largestRectangleArea(int[] heights) {
        if (heights.length==1){
            return heights[0];
        }
        int s=0;
        int end=heights.length-1;
        int area=0;
        while (s<=end){
            int newArea=travel(heights,s);
            area=Math.max(newArea,area);
            s++;
        }
        return area;
    }
    public static int travel(int []arr,int p){
        int area=0;
        if (p==0){
//            right side
            int d=0;
            int p1=p;
            int number=arr[p];
            while (p<arr.length-1){
                if (number<=arr[p+1]){
                    d++;
                }else {
                    break;
                }
                p++;
            }
            area=(d-p1+1)*arr[p1];
        } else if (p > 0 && p < arr.length - 1) {
            // right side;
            int d=p;
            int p1=p;
            int number=arr[p];
            while (p<arr.length-1){
                if (number<=arr[p+1]){
                    d++;
                }else {
                    break;
                }
                p++;
            }
            p=p1;
//            left side move
            int s=p;
            boolean flag=false;
            while (p!=0){
                int numb=0;
                if (p>0){
                    numb=arr[p-1];
                    flag=true;
                }
                if (flag&&number <=numb){
                    s--;
                    flag=false;
                }else {
                    break;
                }
                p--;
            }
            area=(d-s+1)*arr[p1];
        }
        else {
            int s=p;
            int p1=p;
            boolean flag=false;
            int number=arr[p];
            while (p!=0){
                int numb=0;
                if (p>0){
                    numb=arr[p-1];
                    flag=true;
                }
                if (flag&&number<=numb){
                    s--;
                    flag=false;
                }else {
                    break;
                }
                p--;
            }
            area=(p1-s+1)*arr[p1];
        }
        return area;
    }

    public static void main(String[] args) {
        int []arr=new int[]{5,5,1,7,1,1,5,2,7,6};
        System.out.println(largestRectangleArea(arr));
    }

}
