public class Main {
    public static void main(String[] args) {
        CusHashSet<Integer> hashSet=new CusHashSet<>();
        hashSet.insert(7);
        hashSet.insert(6);
        hashSet.insert(5);
        hashSet.insert(3);
        hashSet.insert(2);
        hashSet.insert(1);
        System.out.println(hashSet);
    }
}
