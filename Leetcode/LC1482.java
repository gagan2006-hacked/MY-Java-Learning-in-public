package Leetcod;

public class LC1482 {
    public static void main(String[] args) {
        int []arr=new int[]{1,10,3,10,2};
        System.out.println(toIterate(arr,2,3));
    }
    public static int toIterate(int[] arr, int k,int m) {
        int min = arr[0], sum = 0;
        for (int num : arr) {
            min = Math.min(min, num);
            sum =Math.max(sum,num);
        }
        return isPossiable(arr,min,sum,m,k);
    }

    private static int isPossiable(int[] arr, int min, int max,int m,int k) {
        boolean []ar=new boolean[arr.length];
        int trueCount=0;
        int ans=-1;
        boolean b=false;
        if (ar.length>=(m*k)){
        while (min<=max){
            int mid=(max+min)/2;
            if ((min==mid)&&mid==max){
                return mid;
            }
            for (int i=0;i<arr.length;i++){
                if (arr[i]<=mid){
                    ar[i]=true;
                    trueCount+=1;
                }
            }

            if (trueCount>=(k*m)){
                if(isDone(ar,m,k,trueCount)){
                    ans=mid;
                    max=mid;
                    b=true;
                }else {
                    b=false;
                }
                trueCount=0;
            }else {
                b=false;
            }
            if ((!b)&&trueCount<(k*m)){
                min=mid+1;
                trueCount=0;
            }
        }}
        return ans;
    }

    private static boolean isDone(boolean[] ar, int m, int k,int count) {
        if (k==1){
            if (count==m*k){
                return true;
            }
        }
        int bouquet=0;
        int adjCount=0;
        int i=0;
        while (bouquet<m){
           while ((i<ar.length)&&adjCount<k){
               if (ar[i]){
                   adjCount+=1;
               }else {
                   adjCount-=1;
               }
               i++;
           }
           if (i==ar.length){
               return false;
           }
           if (adjCount==k){
               bouquet+=1;
               adjCount=0;
           }
        }
        return bouquet==m;
    }
}
