package com.Leetcode;

import com.OOPs.SegmentTree;

import java.util.Arrays;

public class LC238 {
    /*public static int[] productExceptSelf(int[] nums) {
        SegmentTree tree = new SegmentTree(nums);
        int n = nums.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int left = (i == 0) ? 1 : tree.getDataOfInterval(0, i - 1);
            int right = (i == n - 1) ? 1 : tree.getDataOfInterval(i + 1, n - 1);
            arr[i] = left * right;
        }

        return arr;
    }*/


    /* TC=O(3N) ans SC=O(3N);
    public static int[] productExceptSelf(int[] nums) {
        int []pre=new int[nums.length];
        int []pos=new int[nums.length];
        int ans[]=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i==0){
                pre[i]=1;
            }else {
                int pr=nums[i-1]*pre[i-1];
                pre[i]=pr;
            }
        }
        for (int i = nums.length-1; i>=0 ; i--) {
            if (i== nums.length-1){
                pos[i]=1;
            }else {
                int po=nums[i+1]*pos[i+1];
                pos[i]=po;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i]=pre[i]*pos[i];
        }
        return ans;
    }*/

     public static int[] productExceptSelf(int[] nums) {
        int ans[]=new int[nums.length];
        int pre=1,pos=1;
         for (int i = 0; i < nums.length; i++) {
             if (i==0){
                 ans[i]=pre;
             }else {
                 pre*=nums[i-1];
                 ans[i]=pre;
             }
         }

         for (int i = nums.length-1; i >=0; i--) {
             if (i== nums.length-1){
                 ans[i]*=pos;
             }else {
                 pos*=nums[i+1];
                 ans[i]=pos*ans[i];
             }
         }
         return ans;
    }


    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }
}
