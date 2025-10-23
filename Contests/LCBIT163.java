package com.Contests;

public class LCBIT163 {
    /*public int minSensors(int n, int m, int k) {
        boolean [][]grif=new boolean[n][m];
        int i=Integer.MAX_VALUE;
        for (int j = 0; j < grif.length; j++) {
            i=Math.min(i,minSensorsHelper(grif,0,1,k));
        }
        return i;
    }*/
    public static long perfectPairs(int[] arr) {
        int pair=0;
        int listIT=1;
        for (int i = 0; i < arr.length-1; i++) {
            listIT=i+1;
            int a=arr[i];
            while (listIT<arr.length){
                int b=arr[listIT];
                int subAB=a-b;
                int addAB=a+b;
                if (addAB<0){
                    addAB*=-1;
                }
                if (subAB<0){
                    subAB*=-1;
                }
                int min=Math.min(addAB,subAB);
                int max=Math.max(addAB,subAB);
                if (a<0){
                    a*=-1;
                }
                if (b<0){
                    b*=-1;
                }
                int minN=Math.min(a,b);
                int maxN=Math.max(a,b);
                if (min<=minN && max>=maxN){
                    pair++;
                }
                listIT++;
            }
        }
        return pair;
    }

    public static void main(String[] args) {
        System.out.println(perfectPairs(new int[]{1,10,100,1000}));
    }
}
