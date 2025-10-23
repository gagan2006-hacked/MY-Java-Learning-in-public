package com.company;

import java.util.Arrays;
import java.util.List;

public class MergeSortUser {
    public static <ListNode> void main(String[] args) {
      int []arr=new int[4];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]= arr.length-i;
        }
        mergesortOP(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
/*public static int [] mergesortOP(int []arr){
if (arr.length==1)return arr;
int mid =arr.length/2;
int []left=mergesortOP(Arrays.copyOfRange(arr,0,mid));
int []right=mergesortOP(Arrays.copyOfRange(arr,mid,arr.length));
return merge(left,right);
}*/

/*    private static int[] merge(int[] left, int[] right) *//*{
        int []arr=new int [left.length+right.length];
        int i=0,j=0,k=0;
        while (i< left.length&& j< right.length) {
            if (left[i] > right[j]) {
                arr[k] = right[j];
                j++;
            } else {
                arr[k] = left[i];
                i++;
            }
            k++;
        }
        while (j==right.length&&i< left.length){
            arr[k] = left[i];
            i++;
            k++;
        }
        while (i==left.length&&j<right.length){
            arr[k] = right[j];
            j++;
            k++;
        }
        return arr;
    }
*/
     public static void  mergesortOP(int []nums,int start,int end){
    if (start==end)return;
    int mid =(start+end)/2;
    mergesortOP(nums,start,mid);
    mergesortOP(nums,mid+1,end);
    merge(nums,start,mid,end);
}
    static void merge(int []nums,int s,int m,int e) {
    int []sortVer=new int[e-s +1];
    int i=s;int j=m+1; int k=0;
    while(i<=m && j<=e){
        if (nums[i]<nums[j]){
            sortVer[k++]=nums[i++];
        }else {
            sortVer[k++]=nums[j++];
        }
    }
    while (i<=m){
        sortVer[k++]=nums[i++];
    }
    while(j<=e){
        sortVer[k++]=nums[j++];
    }
    for (int l = 0; l <sortVer.length ; l++) {
        nums[s+l]=sortVer[l];
    }

}

}
