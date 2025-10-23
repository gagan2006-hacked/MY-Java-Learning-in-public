package com.Contests;

import javax.security.auth.login.CredentialException;
import java.util.Arrays;
import java.util.HashSet;

public class LCBIT165 {
    public static int smallestAbsent(int[] arr) {
        int avg=0;
        HashSet<Integer>set=new HashSet<>();
        int max=-101;
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
            avg+=arr[i];
            max=Math.max(arr[i],max);
        }
        avg=avg/ arr.length;
        int ma=1;
        if (max<0){
            return 1;
        }
        for (int i = (avg<0)?1:avg+1; i<=max+1; i++) {
           if (!set.contains(i)){
               return i;
           }
        }
        return max+1;
    }

    public static void main(String[] args) {
        System.out.println(smallestAbsent(new int[]{-34}));
    }
}
