package com.company;

import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CusHashSet<T> {
    private LinkedList<T>[] arr;
    private final int DEFAULT_SIZE=100;
    private int siz=0;
    public CusHashSet(){
        arr=new LinkedList[siz];
        siz=DEFAULT_SIZE;
    }
    public CusHashSet(int size){
        if (size % 2 == 0) {
            size=size+1;
        }
        arr=new LinkedList[size];
        siz=size;
    }
    public CusHashSet(List<T> result){

    }
    private long  getHash(T val){
        return val.hashCode();
    }
    public void insert(T value){
        long hash=getHash(value)%siz;
        LinkedList<T> head=arr[(int) hash];
        if (arr[(int) hash]==null){
            LinkedList<T> ne=new LinkedList<>();
            ne.add(value);
            arr[(int) hash]=ne;
            return;
        }
        if (head.contains(value)){
            return;
        }
        head.addLast(value);
    }
    public T remove(T value) throws Exception{
        if (isEmpty(arr)){
            throw new Exception("Hash set is empty");
        }
        long hash=getHash(value)%siz;
        LinkedList<T> head=arr[(int)hash];
        if (head.isEmpty()){
            throw new NoSuchObjectException("object "+value+" not found ");
        }
        if (head.remove(value)){
            return value;
        }
        return  null;
    }

    private boolean isEmpty(LinkedList<T>[] arr) {
        for (LinkedList<T> list:arr){
            if (list!=null){
                return false;
            }
        }
        return true;
    }
    public boolean contains(T value){
        long hash=getHash(value)%siz;
        if (!(hash>=0 && hash<siz)){
            return false;
        }
        LinkedList<T> head=arr[(int)hash];
        if (head==null){
            return false;
        }
        return head.contains(value);
    }

    @Override
    public String toString() {
        String string="";
        for (int i= 0; i <siz; i++) {
            LinkedList<T> head=arr[i];
            if (head==null){
                continue;
            }
            string+=head.toString().replace('[',' ').replace(']',' ')+',';
        }
        return string;
    }
}