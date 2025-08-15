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
}
