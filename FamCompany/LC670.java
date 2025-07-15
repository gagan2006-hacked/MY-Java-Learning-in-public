package com.FamCompany;

import java.util.Arrays;

public class LC670 {
/*
    public  static int maximumSwap(int num) {
        if (num==0){
            return 0;
        }
        String og=""+num;
        return maxHelper("",og,num);
    }
    public static int maxHelper(String v,String og,int number){
        int s=0;
        int e=og.length()-1;
        for (int i = 0; i <og.length()-1; i++) {
            s=i+1;
            e=og.length()-1;
            while (s <= e) {
                if (og.charAt(s)-'0'>og.charAt(e)-'0'){
                    e--;
                } else {
                    s++;
                }
            }

            if (og.charAt(e)-'0'>og.charAt(i)-'0'){
                number=Math.max(swapString(og,i,e,v),number);
            }
        }
        return number;
    }

    private static int  swapString(String og, int i, int e,String v) {
        int number=0;
        if (e>=0){
            int s=0;
            while (s<og.length()){
                int po=og.length()-1-s;
                int bse=(int)Math.pow(10,po);
                if (s==i){
                    v+=og.charAt(e);
                    number+=bse*(og.charAt(e)-'0');
                    s++;
                    continue;
                }
                if (s==e){
                    v+=og.charAt(i);
                    number+=bse*(og.charAt(i)-'0');
                    s++;
                    continue;
                }
                v+=og.charAt(s);
                number+=bse*(og.charAt(s)-'0');
                s++;
            }
        }
        return number;
    }
*/

public static int maximumSwap(int num) {
    if (num==0){
        return 0;
    }
    String o=""+num;
    int []arr=new int[o.length()];
    for (int i = 0; i <arr.length; i++) {
        arr[i]=o.charAt(i)-'0';
    }
    int []max= Arrays.copyOf(arr,arr.length);
    Arrays.sort(max);
    for (int i = 0; i < arr.length; i++) {
        if (arr[i]==9){
            continue;
        }
        int number=arr[i];
        for (int j = max.length-i-1; j>=0 && max[j]>number ;j--) {
            int ind=i;
            int index=j;
            while (ind<arr.length){
                int numb=arr[ind];
                if (numb==max[j]){
                   index=ind;
                }
                ind++;
            }
            int t=arr[i];
            arr[i]=max[j];
            arr[index]=t;
            num=Math.max(num,getNumber(arr));
            return num;
        }
    }

    return num;
}
public static int getNumber(int[]arr){
    int number=0;
    int power=0;
    for (int i = arr.length-1; i >=0; i--) {
        number+=(arr[i]*(int)(Math.pow(10,power)));
        power++;
    }
    return number;
}


    public static void main(String[] args) {
        System.out.println(maximumSwap(98368));
    }
}
