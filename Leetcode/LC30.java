package com.Leetcode;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC30 {
    /*
    TC(N)
    brute force;
    public static List<Integer> findSubstring(String s, String[] words) {
        HashSet<String>set=permutation(words,1,words[0].length(),"");
        int total=words[0].length()*words.length;
        List<Integer>list=new ArrayList<>();
        for (int i = 0; i <s.length(); i+=words[0].length()) {
            if (i+total>=s.length()){
                break;
            }
            String string=s.substring(i,total+i);
            if (set.contains(string)){
                list.add(i);
            }
        }
        return list;
    }

    // TC BIGOF(n*n!);
    private static HashSet<String> permutation(String[]arr,int place,int size,String s){
        if (arr.length==0){
            HashSet<String> set=new HashSet<>();
            set.add(s);
            return set;
        }
        HashSet<String>set=new HashSet<>();
        for (int i = 0; i<place; i++) {
            String f=s.substring(0,size*i);
            String b=s.substring(size*i);
            set.addAll(permutation(Arrays.copyOfRange(arr,1,arr.length),place+1,size,f+arr[0]+b));
        }
        return set;
    }
    */

    public static void main(String[] args) {
//        System.out.println(permutation(new String[]{"word","good","best","word"},1,4,""));
//        System.out.println(findSubstring("barfoothefoobarman",new String[]{"foo","bar"}));
    }
}
