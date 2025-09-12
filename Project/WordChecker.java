package com.Project;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

public class WordChecker {
    List<String> dbms = Arrays.asList(
            "Artificial intelligence",
            "Natural Language Processing",
            "Computer language",
            "Intelligence Processing",
            "Language Processing"
    );

    public static void main(String[] args) {
        List<String> input = Arrays.asList("Language", "Artificial");
        WordChecker wc = new WordChecker();
        System.out.println(wc.makeWord(input));
    }

    public List<String> makeWord(List<String> list1) {
        Set<String> resultSet = new LinkedHashSet<>();
        for (String s : list1) {
            findMatchingWords(s.toLowerCase(), resultSet);
        }
        return new ArrayList<>(resultSet);
    }

    private void findMatchingWords(String s, Set<String> result) {
        for (String string : dbms) {
            if (string.replace(" ", "").toLowerCase().contains(s)) {
                result.add(string);
            }
        }
    }
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
}
