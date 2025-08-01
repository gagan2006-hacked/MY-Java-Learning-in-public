import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CusHashSet<T> {
    private List<LinkedList<T>> list;
    private final int DEFAULT_SIZE=100;
    int siz=0;
    public CusHashSet(){
        list=new ArrayList<>(DEFAULT_SIZE);
        siz=DEFAULT_SIZE;
    }
    public CusHashSet(int size){
        list=new ArrayList<>(size);
        siz=size;
    }
    public CusHashSet(List<T> result){
        list=new ArrayList<>(DEFAULT_SIZE);
        siz=DEFAULT_SIZE;
        for (T v:result){
            insert(v);
        }
    }
    private long  getHash(T val){
        return val.hashCode();
    }
    public void insert(T value){
        long hash=getHash(value)%siz;
        LinkedList<T> head=list.get((int)hash);
        if (head.contains(value)){
            return;
        }
        if (head.isEmpty()){
            head.add(value);
            return;
        }
        head.addLast(value);
    }
    public T remove(T value) throws Exception{
        if (list.isEmpty()){
            throw new Exception("Hash set is empty");
        }
        long hash=getHash(value)%siz;
        LinkedList<T> head=list.get((int)hash);
        if (head.isEmpty()){
            throw new NoSuchObjectException("object "+value+" not found ");
        }
        if (head.remove(value)){
            return value;
        }
        return  null;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
