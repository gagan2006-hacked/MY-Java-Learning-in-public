package com.GfG;

import java.util.Arrays;

import static com.company.Dissper_elle.swap;

public class  RotateArray {
    public static void main(String[] args) {
        int []arr=new int[]{1,2,3,4,5,6};
        rotateArr(arr,2);
        System.out.println(Arrays.toString(arr));
    }
    /*if(r>arr.length){
            r%=arr.length;
        }
        int p=r-1;
        int limit=arr.length-r;
        int j=r;
        int it=0;
        boolean tt=false;
        for (int i=arr.length-1;p>=0;i--){
            swap(arr,i,p);
            p--;
        }
        if(j>limit){
            j=limit-1;
        }
        for(int i=it;j<limit;i++){
            swap(arr,i,j);
            j++;
            it++;
            tt=true;
        }
        j-=1;
        if(tt){
            for(int i=it;i<=j;i++){
                swap(arr,i,j);
            }
        }*/
    public static void rArray(int []arr,int i){
        if (i >arr.length){
            i%=arr.length;
        }
        String value="";
        for (int j=0;j<i;j++){
            value+=""+arr[j];
        }int k=0;
        for (int j=i;j< arr.length;j++){
            arr[k]=arr[j];
            k++;
        }
        for (int j = k; j < arr.length ; j++) {
            arr[j]=value.charAt(0)-'0';
            value=value.substring(1);
        }
    }
    static void rotateArr(int arr[], int r) {
        // add your code here
        int n=arr.length;
        r%=n;
        swap(arr,0,r-1);
        swap(arr,r,n-1);
        swap(arr,0,n-1);
    }
    public static void swap(int []arr,int i,int j){
        while (i<j){
            int t=arr[i];
            arr[i]=arr[j];
            arr[j]=t;
            i++;
            j--;
        }
    }
    public static void rotateLeft(int[] arr, int d) {
        int n = arr.length;
        d %= n; // Handle d > n

        // Step 1: Reverse first d elements
        reverse(arr, 0, d - 1);

        // Step 2: Reverse remaining n-d elements
        reverse(arr, d, n - 1);

        // Step 3: Reverse the whole array
        reverse(arr, 0, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            // Swap arr[start] and arr[end]
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
