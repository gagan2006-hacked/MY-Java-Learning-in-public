package com.Leetcode;

public class LC812NOTSOLVED {
    public static double largestTriangleArea(int[][] points) {
        if (points.length<2){
            return 0;
        }
        double area=0;
        for (int i = 0; i <points.length-1; i++) {
            for (int j = i+1; j < points.length; j++) {
                double f= (double) (points[i][0] * points[j][1]) /2;
                double g=(double) (points[i][1]*points[j][0])/2;
                area=Math.max(area,f);
                area=Math.max(area,g);
            }
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(largestTriangleArea(new int[][]{{4,6},{6,5},{3,1}}));
    }
}
