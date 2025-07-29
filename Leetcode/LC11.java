package com.Leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class LC11 {
    public static int maxArea(int[] height) {
        int s=0;
        int end= height.length-1;
        int area=-1;
        while (s<end){
            int newarea=Math.min(height[s],height[end])*(end-s);
            if (area<newarea){
                area=newarea;
            }
            if (height[s]>height[end]){
                end--;
            } else if (height[s]<height[end]) {
                s++;
            }else {
                s++;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

}
