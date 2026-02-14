package com.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class LC767 {
    public static String reorganizeString(String s) {
        HashMap<Character,Integer>charMap=new HashMap<>();
        int maxF=0;
        for (char c:s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            maxF=Math.max(maxF,charMap.get(c));
        }
        if (maxF>(s.length()+1)/2)return "";
        PriorityQueue<Character> pq =
                new PriorityQueue<>((a, b) -> charMap.get(b) - charMap.get(a));
        for (char c : charMap.keySet()) {
            pq.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 1) {
            char first = pq.poll();
            char second = pq.poll();

            sb.append(first);
            sb.append(second);

            charMap.put(first, charMap.get(first) - 1);
            charMap.put(second, charMap.get(second) - 1);

            if (charMap.get(first) > 0) pq.offer(first);
            if (charMap.get(second) > 0) pq.offer(second);
        }
        if (!pq.isEmpty()){
            sb.append(pq.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("sfffp"));
    }
}
