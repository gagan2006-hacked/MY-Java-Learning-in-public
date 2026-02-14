package com.LCQuest;

import java.util.*;

public class Q1 {
    public int[] getConcatenation(int[] nums) {
        int []arr=new int[2* nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=nums[i% nums.length];
        }
        return arr;
    }
    public static int[] shuffle(int[] nums, int n) {
        int []arr=new int[nums.length];
        int i=0;
        int iL= (nums.length/2)-1;
        int j=iL+1;
        int k=0;
        while (i<=iL&&j<nums.length){
            arr[k++]=nums[i];
            arr[k]=nums[j];
            i++;
            j++;
            k++;
        }
        return arr;
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                max= Math.max(max,count);
                count=0;
            }else {
                count++;
            }
        }
        if (count!=0){
            max=Math.max(count,max);
        }
        return max;
    }
    public static int[] findErrorNums(int[] nums) {
        int []arr={-1,-1};
        int ele=0;
        int miss=0;
        HashSet<Integer>set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                ele=nums[i];
                miss=find(nums);
            }else {
                set.add(nums[i]);
            }

        }
        if (ele!=0&&miss!=0){
            arr[0]=ele;
            arr[1]=miss;
        }
        return arr;
    }
    public static int find(int []arr){
        HashSet<Integer>set=new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        for (int i = 1; i <=arr.length; i++) {
            if (!set.contains(i)){
                return i;
            }
        }
        return -1;
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int arr[]=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i!=j&&nums[j]<nums[i]){
                    arr[i]+=1;
                }
            }
        }
        return arr;
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        TreeSet<Integer>set=new TreeSet<>();
        List<Integer>list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 1; i <= nums.length ; i++) {
            if (!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(shuffle(new int[]{1,2,3,4,4,3,2,1},4)));
//        System.out.println(Arrays.toString(findErrorNums(new int[]{3,2,2})));
//        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new  int[]{8,1,2,2,3})));
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

}
