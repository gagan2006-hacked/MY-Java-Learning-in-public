package com.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC56 {
    /*public static int[][] merge(int[][] intervals) {
        List<List<Integer>>list=new ArrayList<>();
        boolean flag=false;
        for (int []row:intervals){
            if (list.isEmpty()){
                list.add(new ArrayList<>(Arrays.stream(row)
                        .boxed()
                        .toList()));
                continue;
            }
            for (int i = 0; i < list.size(); i++) {
                List<Integer>integers=list.get(i);
                int start=integers.get(0);
                int end=integers.get(1);
                int startD=row[0];
                int endD=row[1];
                if (changeMade(start,startD,endD,end,integers)){
                    flag=true;
                    break;
                }
            }
            if (!flag){
                list.add(new ArrayList<>(Arrays.stream(row)
                        .boxed()
                        .toList()));
            }
            flag = false;
        }
        Collections.sort(list, (a, b) -> a.get(0) - b.get(0));
        int arr[][]=new int[list.size()][2];
        for (int i = 0; i < arr.length; i++) {
            List<Integer>integers=list.get(i);
            for (int j = 0; j <2; j++) {
                arr[i][j]=integers.get(j);
            }
        }

        return arr;
    }

    private static boolean changeMade(int start, int startD, int endD, int end, List<Integer> integers) {
        if (startD<=end && end<=endD){
            integers.set(0,start);
            integers.set(1,endD);
        } else if (start<=startD && endD<=end) {
        } else if (start>startD && endD>=start) {
            integers.set(0,startD);
            integers.set(1,end);
        } else {
            return false;
        }
        return true;
    }*/

    public static int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) return intervals;

        // 1️⃣ Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        int[] current = intervals[0];
        result.add(current);

        // 2️⃣ Merge intervals
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (next[0] <= current[1]) {
                // Overlap → merge
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap → new interval
                current = next;
                result.add(current);
            }
        }

        // 3️⃣ Convert List to Array
        return result.toArray(new int[result.size()][2]);
    }


    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{5,7},{1,4}})));
    }
}
