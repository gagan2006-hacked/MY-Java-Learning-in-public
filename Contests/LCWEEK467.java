package com.Contests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LCWEEK467 {
    public static int earliestTime(int[][] tasks) {
        int eTime=Integer.MAX_VALUE;

        for (int []row:tasks){
            int rt=row[0]+row[1];
            eTime=Math.min(eTime,rt);
        }
        return eTime;
    }
    public static int[] maxKDistinct(int[] arr, int k) {
        HashSet<Integer>set=new HashSet<>();
        int max=0;
        Arrays.sort(arr);
        List<Integer>list=new ArrayList<>();
        for (int i = arr.length-1; i>=0 ; i--) {
            if (!set.contains(arr[i])&&k>0){
                list.add(arr[i]);
                set.add(arr[i]);
                k--;
            }
        }
        int []ar=new int[list.size()];
        for (int i = 0; i <list.size(); i++) {
            ar[i]=list.get(i);
        }
        return ar;
    }
    public static boolean[] subsequenceSumAfterCapping(int[] arr, int k) {
        boolean []res=new boolean[arr.length];
        for (int x = 1; x <=arr.length; x++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                list.add(Math.min(x, arr[i]));
            }
            if (findIfpossiable(list,k)){
                res[x-1]=true;
            }
        }
        return res;
    }

    private static boolean findIfpossiable(List<Integer> list,int k) {
        int s=0;
        int sum=0;
        for (int i = 0; i <list.size(); i++) {
            if (sum==k){
                break;
            }
            if (sum>k){
                sum=sum-list.get(s);
                s++;
            }
            sum+=list.get(i);
        }
        return sum==k;
    }

    public static void main(String[] args) {
//        System.out.println(earliestTime(new int[][]{{1,6},{2,3}}));
//        System.out.println(Arrays.toString(maxKDistinct(new int[]{84,93,100,77,90},3)));
        System.out.println(Arrays.toString(subsequenceSumAfterCapping(new int[]{4,3,2,4},8)));

    }
}
