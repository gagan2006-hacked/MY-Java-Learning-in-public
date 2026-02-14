package com.OOPs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TopologicalSort {
    List<LinkedList<Integer>> lists;
    public TopologicalSort(){
        lists=new ArrayList<>();
    }
    public void addAllVertex() throws Exception{
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number of the Vertex ");
        int n=in.nextInt();int i=0;
        while (i<n){
            System.out.println("Enter the vertex {"+i+"} if no vertex are there or left  give -1");
            int data=in.nextInt();
            if (data==-1){
                if (i>= lists.size()) {
                    lists.add(i, null);
                }
                i++;continue;
            }
            if (i>= lists.size()) {
                lists.add(i, new LinkedList<>());
            }
            lists.get(i).add(data);
        }
    }
    public List<Integer> sort(){
        List<LinkedList<Integer>>list=new ArrayList<>(lists);
        List<Integer>graph=new ArrayList<>();
        while (!list.isEmpty()){
            int ele=-1;
            for (int i = 0; i <list.size(); i++) {
                if (list.get(i)==null){
                    ele=i;break;
                }
            }

            if (ele==-1){
                System.out.println("Graph Has a Cycle in it ");return new ArrayList<>();
            }

            for (int i = 0; i <list.size(); i++) {
                if (list.get(i)!=null&&list.get(i).contains(ele)){
                    list.get(i).remove(ele);
                    if (list.get(i).isEmpty()){
                        list.set(i,null);
                    }
                }
            }
            graph.add(ele);
            list.remove(ele);
        }
        return graph;
    }

    public static void main(String[] args) throws Exception {
        TopologicalSort sort=new TopologicalSort();
        sort.addAllVertex();
        System.out.println(sort.lists);
        System.out.println(sort.sort());
    }
}
