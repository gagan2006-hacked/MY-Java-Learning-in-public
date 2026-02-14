package com.OOPs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph <T> {
    private HashMap<T, List<T>> map;
    public  Graph(){
        map=new HashMap<>();
    }
    public boolean addEdge(T node,T subNode,boolean isDirectional){
        try {
            if (map.containsKey(node)){
                List<T> list=map.get(node);
                list.add(subNode);
            }else {
                List<T>list=new ArrayList<>();
                list.add(subNode);
                map.put(node,list);
            }
            if (!isDirectional){
                if (map.containsKey(subNode)){
                    List<T> list=map.get(subNode);
                    list.add(node);
                }else {
                    List<T>list=new ArrayList<>();
                    list.add(node);
                    map.put(subNode,list);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public String toString(){
        StringBuilder builder=new StringBuilder();
        for (Map.Entry<T,List<T>>entry: map.entrySet()){
            builder.append(entry.getKey()).append("->").append(entry.getValue()).append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        /*Graph<Integer> graph=new Graph<>();
        graph.addEdge(0,1,false);
        graph.addEdge(1,2,false);
        graph.addEdge(2,3,false);
        graph.addEdge(3,4,false);
        graph.addEdge(4,0,false);
        System.out.println(graph);*/
    }
}
