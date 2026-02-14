package com.Leetcode;



import java.util.*;

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
    *//*



    public static List<Integer> findSubstring(String s, String[] words) {
        int l=words.length*words[0].length();

        if (l>s.length()){
            return new ArrayList<>();
        }
        HashMap<String,Integer>map=new HashMap<>();
        for (String string:words){
            if (map.containsKey(string)){
                map.put(string,map.get(string)+1);
            }else {
                map.put(string,1);
            }
        }

        int length=words[0].length();
        List<Integer>list=new ArrayList<>();
        for (int i = 0; i<=s.length()-l; i+=length) {
            String sub=s.substring(i,i+l);
            if (ifContains(sub,new HashMap<String,Integer>(map),length)){
                list.add(i);
            }
        }
        return list;
    }

    private static boolean ifContains(String s, HashMap<String, Integer> map,int len) {
        if (s.isEmpty()){return false;}
        int w=0;
        while (w<s.length()){
           String word=s.substring(w,w+len);
            if (map.containsKey(word)){
                map.put(word,map.get(word)-1);
                if (map.get(word)==0){
                    map.remove(word);
                }
            }else {
                return false;
            }
            w+=len;
        }
        return true;
    }*/


















    /*public static List<Integer> findSubstring(String s, String[] words) {
        int size= words.length*words[0].length();
        int wordSize= words[0].length();
        if (s.length()<size)return new ArrayList<>();
        HashMap<String,Integer>map=new HashMap<>();
        List<Integer>list=new ArrayList<>();
        for (String wo:words) map.put(wo, map.containsKey(wo) ? map.get(wo) + 1 : 1);
        for (int i = 0; (i+size-1)<s.length(); i+=words[0].length()) {
            String string=s.substring(i,i+size);
            int num=checkString(string,new HashMap<String,Integer>(map),wordSize);
            if (num!=-1)list.add(i);
        }
        return list;
    }

    private static int checkString(String string, HashMap<String, Integer> map,int size) {
        int index=-1;
        for (int i = 0;i<string.length(); i+=size) {
            String sub=string.substring(i,i+size);
            if (map.containsKey(sub)){
                map.put(sub,map.get(sub)-1);
                if (map.get(sub)==0)map.remove(sub);
                if (index==-1)index=i;
            }else {
                return -1;
            }
        }
        return index;
    }*/

    /*public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;

        if (s.length() < totalLen) return result;

        HashMap<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        for (int i = 0; i + totalLen <= s.length(); i++) {
            if (isValid(s.substring(i, i + totalLen), map, wordLen)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean isValid(String str, HashMap<String, Integer> map, int size) {
        HashMap<String, Integer> temp = new HashMap<>(map);

        for (int i = 0; i < str.length(); i += size) {
            String sub = str.substring(i, i + size);
            if (!temp.containsKey(sub)) return false;

            temp.put(sub, temp.get(sub) - 1);
            if (temp.get(sub) == 0) temp.remove(sub);
        }
        return temp.isEmpty();
    }*/

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0) return res;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        Map<String, Integer> freq = new HashMap<>();
        for (String w : words)
            freq.put(w, freq.getOrDefault(w, 0) + 1);

        for (int start = 0; start < wordLen; start++) {
            Map<String, Integer> window = new HashMap<>();
            int left = start, count = 0;

            for (int right = start; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (!freq.containsKey(word)) {
                    window.clear();
                    count = 0;
                    left = right + wordLen;
                    continue;
                }

                window.put(word, window.getOrDefault(word, 0) + 1);
                count++;

                while (window.get(word) > freq.get(word)) {
                    String leftWord = s.substring(left, left + wordLen);
                    window.put(leftWord, window.get(leftWord) - 1);
                    left += wordLen;
                    count--;
                }

                if (count == wordCount) {
                    res.add(left);
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
//        System.out.println(permutation(new String[]{"word","good","best","word"},1,4,""));
        System.out.println(findSubstring("barfoofoobarthefoobarman",new String[]{"bar","foo","the"}));

    }
}
