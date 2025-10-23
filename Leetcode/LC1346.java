package com.Leetcode;

import java.util.HashSet;

public class LC1346 {
//    this skip for 0 condtion like[1,9,3,8,0] this give true but actual false
   /* public boolean checkIfExist(int[] arr) {
        HashSet<Integer> list=new HashSet<>();
        for (int ele:arr){
            list.add(ele);
        }
        for (int ele:arr){
            int toCheck=2*ele;
            if (list.contains(toCheck)){
                return true;
            }
        }
        return false;
    }*/
//     by checking the number in advance we are iterating on array
public boolean checkIfExist(int[] arr) {
    HashSet<Integer> set = new HashSet<>();
    for (int ele : arr) {
        if (set.contains(2 * ele) || (ele % 2 == 0 && set.contains(ele / 2))) {
            return true;
        }
        set.add(ele);
    }
    return false;
}
}
