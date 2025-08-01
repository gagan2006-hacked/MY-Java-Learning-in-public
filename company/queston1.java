import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class queston1 {

public static List<List<Integer>> evenandeood(int[]arr){
    List<List<Integer>>res=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    List<Integer>list1=new ArrayList<>();
    for (int ele:arr){
        if (ele%2==0){
            list1.add(ele);
        }else {
            list.add(ele);
        }
    }
    res.add(list1);
    res.add(list);
    return res;
}
public static int weirdSum(int n){
    long facSum=facto(n);
    System.out.println("sum=="+facSum);
    return (int)facSum%1000;
}

    private static long facto(int n) {
    long i=1;

  long sum=1;
    for (int j=2;j<=n;j++){
        i*=j;
        sum+=i;
    }
    System.out.println("fac :"+i);
    return sum;
}
public static int firstMiss(int []arr){
    int s=0;
    int e=arr.length-1;
    Arrays.sort(arr);
    int missing=0;
    while (s<e){
        int mid=(s+e)/2;
        missing=arr[mid]-mid-1;
if (missing>=1){
            e=mid;
        }
        else {
            s=mid+1;
        }
    }
    if (missing==0){
        return arr[arr.length-1]+1;
    }
    return arr[s]-missing;
}
/*public static int path(int[][]arr){

}*/
    public static int reverse(int n){
        String s=""+n;
        StringBuilder stringBuilder=new StringBuilder(s);
        stringBuilder.reverse();
        if (stringBuilder.charAt(0)=='0'){
            stringBuilder.deleteCharAt(0);
        }
        Integer i=Integer.parseInt(stringBuilder.toString());
     return i;
    }
    public static void main(String[] args) {
      /*  Scanner in=new Scanner(System.in);
        System.out.println("enter the ele");
        int n=in.nextInt();
        if (n<0){
            return;
        }
        int arr[]=new int[n];
        for (int i=0;i<n;i++){
            System.out.println("enter the ele");
            arr[i]=in.nextInt();
        }*/
//        System.out.println(evenandeood(arr));
//        System.out.println(weirdSum(in.nextInt()));
//        System.out.println(firstMiss(arr));
        System.out.println(reverse(909090));
    }
}
