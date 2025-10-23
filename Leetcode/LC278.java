package com.Leetcode;

public class LC278 {
   /* public int firstBadVersion(int n) {
        return mySoln(n);
    }*/
    public static int mySoln(int n,int target){
        long s=1;
        long e=n;
        int ans=-1;
        while(s<e){
            long mid=(s+e)/2;
            if (mid>target){
                ans=(int)mid;
                e=mid;
            }else {
                s=mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySoln(2,2));
    }
}
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */



