package com.company;
import java.util.*;

public class Assignments {


    private static void fib_usr(int n) {
        int first = 0;
        int sec =1;
        int res;

        for (int i=0;i<=n;i++){
            if (i==0){
                System.out.print(i+" ");
            }else if (i==1){
                System.out.print(i+" ");
            }else {

                res=first+sec;
                first=sec;
                sec=res;
                System.out.print(res+" ");
            }


        }

    }

    public static int fibonacci(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Input should be a positive integer.");
        } else if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    private static void recu_1(int n,int i) {

        System.out.println(n-i);

        if (n==1){
            return;
        }
        recu_1(n-1,i-2);
    }


    private static void pattern31(int n) {
        int on=n;
        for (int i=1;i<(2*n);i++){
            for (int j=1;j<(2*n);j++){
                int n1=on-min(i,j,(2*n-i),(2*n-j))+1;

                System.out.print(n1+" ");
            }
            System.out.println();


        }
    }

    private static void pattern28(int n) {
        int rel=2;

        for (int i=1;i<=(2*n-1);i++){
            int col=((i<=n)? i:(i-rel));
            int space=((i<=n)?(n-i):(i-n));
            for (int k=0;k<space;k++){
                System.out.print(" ");
            }




            for (int j=1;j<=col;j++){
                System.out.print(" *");
            }
            System.out.println();
            if (i>n){
                rel+=2;
            }
        }
    }
    private static void pattern8(int n) {
        for (int i=1;i<=n;i++){

            for (int k=0;k<(n-i);k++){
                System.out.print(" ");
            }

            for (int j=1;j<=i;j++){
                System.out.print( " *");
            }
            System.out.println();
        }
    }
    private int reverseADigit(int n){
        if (n%10==n)return n;
        return (n%10 *(int)(Math.pow(10,(int)Math.log10(n))))+reverseADigit(n/10);
    }
    public boolean PallidromeInt(int n){
        int reverse=PallidromeIntHelper(n);
        return reverse==n;
    }
    static int count=0;
    public int countZeroS(int n){
        int digits=(int )(Math.log10(n))+1;
        int rem=n%10;
        if (rem==0) count+=1;
        if (digits<=1)return count;
        return countZeroS(n/10);
    }
static int sum=1;
    private int PallidromeIntHelper(int n) {
        if (n%10==n)return n;
       int rem=n%10;
       int digit=(int)(Math.log10(n));
       sum=rem*((int) (Math.pow(10,digit)));
        return sum+PallidromeIntHelper(n/10);
    }

    private static void pattern7(int n) {
        for (int i=n;i>0;i--){
            for (int k=0;k<(n-i);k++){
                System.out.print(" ");
            }
            for (int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    private static void pattern6(int n) {
        for (int i=1;i<=n;i++){
            for (int k=0;k<(n-i);k++){
                System.out.print(" ");
            }
            for (int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void pattern5(int n) {
        int rel=2;
        for (int i=1;i<=(2*n-1);i++){
            int col=((i<=n)? i:(i-rel));
            for (int j=1;j<=col;j++){
                System.out.print("* ");

            }
            System.out.println();
            if (i>n){
                rel+=2;
            }
        }
    }


    private static void pattern4(int n) {
        for (int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    private static void pattern3(int n) {
        for (int i=n;i>0;i--){
            for (int j=i;j>0;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    private static void pattern2(int n) {
        for (int i=0;i<n;i++){
            for (int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void pattern1(int n) {
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static public void sort(int nums[]){
        int i=0;
        int peak,end= nums.length-1;
        for (i=0;i<nums.length-1;i++){

            peak=peak(nums,end);
            int temp=nums[end];
            nums[end]=nums[peak];
            nums[peak]=temp;
            end=end-1;

        }


    }
    static public int peak(int arr[],int end){
        int i=0;int lar=0;

        for (i=0;i<=end;i++){
            if (arr[lar]<arr[i]){
                lar=i;
            }
        }
        return lar;
    }
    public static int max(int ...arr){
        int larget=0;
        for (int i=0;i<arr.length;i++){
            if (larget<=arr[i]){
                larget=arr[i];

            }

        }
        return larget;
    }
    public static int min(int ...arr){
        int larget=arr[0];
        for (int i=0;i<arr.length;i++){
            if (larget>arr[i]){
                larget=arr[i];

            }

        }
        return larget;
    }
    public static void identifer(int n){
        if (n%2==0){
            System.out.println("its a even number");
        }else System.out.println("its a odd number");
    }
    private static void votingage(float age) {
        if (age>=18.0f){
            System.out.println("you are eligible ");

        }else System.out.println("you are not eligible ");
    }
    private static int sum1(int...arr) {
        int sum=0;
        for (int i=0;i< arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }
private static int pro(int...arr) {
        int sum=1;
        for (int i=0;i< arr.length;i++){
            sum*=arr[i];
        }
        return sum;
    }
    private static void prime(int n) {
        try{int range=(int)Math.sqrt(n);
            for (int i=2;i<=range;i++){
                if (n%i==0){
                    System.out.println("its not a prime number");
                    return;
                }
            }
            System.out.println("its a prime number");} catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void grade(float marks) {
        if ((marks>=91)&&(marks<=100)){
            System.out.println("AA");
        } else if ((marks>=81)&&(marks<=90)) {
            System.out.println("AB");
        } else if ((marks>=71)&&(marks<=80)) {
            System.out.println("BB");
        } else if ((marks>=61)&&(marks<=70)) {
            System.out.println("BC");
        } else if ((marks>=51)&&(marks<=60)) {
            System.out.println("CD");
        }else if ((marks>=41)&&(marks<=50)) {
            System.out.println("DD");
        }else if (marks<=40){
            System.out.println("Fail");
        }else {
            System.out.println("invaild input");
        }
            /*Marks        Grade
91-100         AA
81-90          AB
71-80          BB
61-70          BC
51-60          CD
41-50          DD
<=40          Fail */

    }
    public static long fac(int n) {
        if (n<=1)return 1L;

        return n*fac(n-1);
//        System.out.print(" = "+mu);
    }
    public int sum_recur(int n){
        if (n<=1)return n;
        return n+sum_recur(n-1);

    }
    public int sumOfDigits(int n){
        if (n==0)return n;
        return sumOfDigits(n/10)+(n%10);
    }

    private static void palin(String next) {
        String rev = "";
        for (int i=next.length()-1;i>=0;i--){
            rev+=next.charAt(i);
        }
        System.out.println("reversed text or number is "+rev);
        if (rev.equalsIgnoreCase(next)){
            System.out.println("its a palinadrome");
        }else {
            System.out.println("its not palinadrome");}

    }

    private static void triplet(int i, int i1, int i2) {
        int largest=max(i,i1,i2);
        if (largest==i){
            if ((i1*i1)+(i2*i2)==(i*i)){
                System.out.println("its a pythagroen triplet");
                return;
            }System.out.println("its not a pythagroen triplet");
        }else if ((largest==i1)){
            if ((i*i)+(i2*i2)==(i1*i1)){
                System.out.println("its a pythagroen triplet");
                return;
            }System.out.println("its not a pythagroen triplet");

        } else if ((largest==i2)) {
            if ((i*i)+(i1*i1)==(i2*i2)){
                System.out.println("its a pythagroen triplet");
                return;
            }
            System.out.println("its not a pythagroen triplet");

        }
    }
    public long multiOfDigitd(long n){
        if (n%10==n)return n;
        return (n%10)*multiOfDigitd(n/10);
    }
    public static List<Integer> primeRetivere(int n,int m){
        int larg=max(n,m);
        int small=min(n,m);
        int check=0;
        List<Integer>lis=new ArrayList<>();
            for (int i=small;i<=larg;i++){
                for (int j=2;j<=((int)Math.sqrt(i));j++){
                    if (i%j==0){
                        check=1;
                        break;
                    }
                }
                if (check==1){
                    //its not prime number so re initazillse
                    check=0;
                }else if (check==0){
                    lis.add(i);

                }
            }
            return lis;
    }
    private static int recursum(int n) {
        if (n==0){
            return 0;
        } else if (n==1) {
            return 1;

        }
        return n+recursum(n-1);
    }



/*
    static public int peakIndexInMountainArray(int[] arr) {
        int beg=0;
        int end=arr.length-1;

        while (beg<=end){
            int  mid=(beg+end)/2;
            if (mid!=1){
                if ((arr[mid-1]<(arr[mid]))&&(arr[mid]>arr[mid+1])){
                    System.out.println("peak value of the array is "+arr[mid]+" and at position"+mid);
                    return mid;

                }}if (beg==mid){

                return end;

            }
            if ((arr[mid]<arr[mid+1])){
                beg=mid+1;

            }else {

                end=mid-1;


            }

        }
        return -1;}
*/
/*
    public static long permuation(int n,int r){
        if ((n == 0) || (r == 0)) {
            return -1;


        }else {
            long mu=1l;
            long nu=1l;
            int cr=1;
            for (int i=1;i<=n;i++){
                mu*=i;
            }for (int i=1;i<=(n-r);i++){
                nu*=i;
            }for (int i=1;i<=r;i++){
               cr*=i;
            }
            long p=mu/(cr*nu);
            return p;
        }

    }
*/
/*
{public static void greet(String na){
    System.out.println("good moring "+na);

}
*/

/*
    public static int findLCM(int a, int b, int hcf) {
        return (a * b) / hcf;
    }

    public static int findHCF(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
*/


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

       /* while (true){
            System.out.println("enter the year");
            int ye=in.nextInt();
        if (ye%4==0){
            System.out.println("its a leap year");
            break;

        }else {
            System.out.println("its a not a leap year");}
    try{
          System.out.println("enter two number");
          int in1= in.nextInt();
          int in2=in.nextInt();
          int sum=in2+in1;
          System.out.println("sum is"+sum);
      }catch (Exception e){
          System.out.println("exception occucerd"+e);
      }
        System.out.println("enter the number");
        int num=in.nextInt();
        for (int i=1;i<=10;i++){
            System.out.println(+num+"*"+i+"="+num*i);
        }
        try{
            System.out.println("do you want more tables ");
            String ch=in.next();
            if ((ch.equalsIgnoreCase("yes"))){
                for (int i=11;i<=20;i++){
                    System.out.println(+num+"*"+i+"="+num*i);
                }
            }else {
                System.out.println("ok bye");}
            }catch(Exception e){
                System.out.println(e);

            }*/
 /*
             Method to calculate HCF using the Euclidean algorithm
             Method to calculate LCM

                            Scanner scanner = new Scanner(System.in);

                            // Prompt user for two numbers
                            System.out.print("Enter the first number: ");
                            int num1 = 8;
                            System.out.print("Enter the second number: ");
                            int num2 = 12;

                            // Compute HCF
                            int hcf = findHCF(num1, num2);

                            // Compute LCM
                            int lcm = findLCM(num1, num2, hcf);

                            // Display results
                            System.out.println("HCF of " + num1 + " and " + num2 + " is: " + hcf);
                            System.out.println("LCM of " + num1 + " and " + num2 + " is: " + lcm);

                            scanner.close();
            */
/*
        int n, sum = 0;
        while (true) {
            try {
                System.out.println("enter the the number");
                n = in.nextInt();
                sum += n;
            } catch (Exception e) {
                System.out.println("exception occured " + e);
                System.out.println("sum of all the number is" + sum);
                break;
            }

        }
*/
/*
        System.out.println("enter the numbers");
        int n1=in.nextInt();
        if (n1%2==0){
            System.out.println("its a even number"+n1);

        }else {
            System.out.println("its  a odd num"+n1);
        }
*/
/*
        System.out.println("enter your name");
        String name=in.next();
        greet(name);
*/
/*
        System.out.println("enter amount, time(in months), interest rate ");
        float pr=in.nextFloat();
        float time =in.nextFloat();
        float ra=in.nextFloat();
        float sim=(pr*ra*time)/100f;
        System.out.println("simple interest is "+sim);
*/
/*
        while (true) {
            System.out.println("enter opertion to perfom (+,*,/,-)");
            String op = in.next();
            switch (op) {
                case "+":
                    System.out.println("enter the numbers");
                    int n1 = in.nextInt();
                    int n2 = in.nextInt();
                    System.out.println(n1 + n2);
                    break;
                case "*":
                    System.out.println("enter the numbers");
                    n1 = in.nextInt();
                    n2 = in.nextInt();
                    System.out.println(n2 * n1);
                    break;
                case "-":
                    System.out.println("enter the numbers");
                    n1 = in.nextInt();
                    n2 = in.nextInt();
                    System.out.println(n1 - n2);
                    break;
                case "/":
                    System.out.println("enter the number");
                    n1 = in.nextInt();
                    n2 = in.nextInt();
                    System.out.println(n1 /n2);
                    break;
                case "exit":
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("invaild input ");

            }
            if (op.equalsIgnoreCase("exit")){
                break;
            }
 }
*/
/*
        try {
            int n1=in.nextInt();
            int n2=in.nextInt();
            if (n2>n1){
                System.out.println(+n2+"is greater than"+n1);

            }else {
                System.out.println(+n1+"is greater than"+n2);
            }

        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("enter ur amount");
        float ru=in.nextFloat();
        float cu=ru/85.178f;
        System.out.println(cu);
*/
/*
        System.out.println("enter the number");
        int n =in.nextInt();
        int n1=0;
        int n2=1;
        for (int i=0;i<n;i++){
            if (i==0){
                System.out.print(+n1+" ");
            }
            if (i==1) {
                System.out.print(" "+n2);

            }else {
                int sum=n1+n2;
                n1=n2;
                n2=sum;
                System.out.print(" "+sum);

            }

        }
*/
/*
        float radius=in.nextFloat();

        float ar= 3.14f*radius*radius;
        System.out.println("area is"+ar);
*/
/*
        float bh,h;
        System.out.println("enter the height ,breadth");
        h=in.nextFloat();
        bh=in.nextFloat();
        System.out.println("area is "+(bh*h)/2);

*/
/*
        float l,h;
        System.out.println("enter the height ,breadth");
        h=in.nextFloat();
        l=in.nextFloat();
        System.out.println("area is "+(l*h));
*/
/*
        System.out.println("enter the number");
        int n=in.nextInt();
        for (int i=1;i<=n;i++){
            if (n%i==0){
                System.out.print(i);
                System.out.print(" ");
            }


        }
        int sum=0;
        while (true){
            System.out.println("enter the number");
            int n=in.nextInt();

            if(n!=0){
                sum+=n;
            }
            if (n==0){
                break;

            }
        }
        System.out.println(sum);
*/
/* to find range of int data type
        int range=(int)(Math.pow(2.32));
*/
/*
        System.out.println("enter the number");
        int n=in.nextInt();
        int fac=1;
        for(int i=1;i<=n;i++){
            fac*=i;

        }
        System.out.println("fac of "+n+" is "+fac);
*/
/*
        System.out.println("enter aount of units");
        float en=in.nextFloat();
        float amt=0;
        if (en<=50){
            System.out.println("amt to paid is"+4*en);
        } else if ((en>50)||(en<101)) {
            amt =amt+(5.25f*(en-50));
            amt=amt+(4*(50));
            System.out.println(amt);


        } else if ((en>100)||(en<201)) {
            amt =amt+(5.25f*(49));
            amt=amt+(4*(50));
            amt=amt+ (6.8f*(en-99f));
            System.out.println(amt);
        }else {
            amt =amt+(5.25f*(49));
            amt=amt+(4*(50));
            amt=amt+(6.8f*99);
            amt=amt+(7.65f*(en-(99+49+50)));
            System.out.println(amt);
        }
        System.out.println("is to be paid");
*/
/*
        int n,sum=0;int n1=0;
        while (true){
            System.out.println("enter the number");
            n=in.nextInt();
            sum+=n;
            n1++;
            if ((n1==10)||(n1==20)){
                System.out.println("do you want t0 contonue (yes/no)");
                String ch=in.next();
                if (ch.equalsIgnoreCase("no")){

                    System.out.println(sum/n1);break;

                }
            }

        }
*/
/*
        System.out.println("enter the discount to apply on product");
        float dis=in.nextFloat();
        System.out.println("enter amout of the product");
        float amt=in.nextFloat();
        float to=((100f-dis)*amt)/100f;
        System.out.println("the amount of the product after discount is"+to);
        System.out.println("the amount of discount applied is"+(amt-to));
*/
/*
        System.out.println("enter the first cordinates");
        float x1=in.nextInt();
        float y1=in.nextFloat();
        System.out.println("enter the second coordinates");
        float x2=in.nextFloat();
        float y2=in.nextInt();
        float dis= ((x2-x1) +(y2-y1));
        double di=Math.sqrt(dis);
        System.out.println("distance is "+di);
*/
/*
        System.out.println("enter the percentage of commisson ");
        float per=in.nextFloat();
        System.out.println("enter the amount");
        float amt =in.nextFloat();
        float com= per*amt/100f;
        System.out.println("the commison amt is "+com);

*/

/*
        System.out.println("enter the number and power");
        int n= in.nextInt();;
        int ex= in.nextInt();
       long re=1;
       for (int i=1;i<=ex;i++){
           re*=n;
       }
        //long re = (int) Math.pow(n,ex);
        System.out.println("power is "+re);
*/
/*
        int av=0;
        System.out.println("enter the number of matches");
        int n=in.nextInt();
        int [] score=new int[n];
        for (int i=0;i<n;i++){
            System.out.println("enter the score");
            score[i]=in.nextInt();


        }
        for (int i: score){
            av+=i;
        }
        System.out.println("enter the number dismissles");
        int di=in.nextInt();
        System.out.println("batting average is "+av/di);
*/
/*
        System.out.println("enter ur total marks");
        float to=in.nextFloat();
        System.out.println("enter the number of subejects");
        float nu=in.nextFloat();
        float cpg= ((to/240)*100f)/9.5f ;
        System.out.println("ur cgpa is "+cpg);
*/
/*
        System.out.println("enter the number of students");
      try{
        int n=in.nextInt();
        int [ ]mark=new int[n];
        for (int i=0;i<n;i++){
            System.out.println("enter the marks ");
            mark[i]=in.nextInt();
        }
        int sum=0;
        for (int ele: mark){
            sum+=ele;

        }
        System.out.println("the average of the marks is"+sum/n);





    } catch (RuntimeException e) {
          throw new RuntimeException(e);
      }
*/
/*
        int n=in.nextInt();
        int sum=0;
        for (int i=1;i<=n;i++){
          sum+=i;
        }
        System.out.println(sum);
*/
/*
        int n=in.nextInt();
       int rem=0;
      int rev=0;
  int sum=0;
        int n1=n;

        while (n1!=0){
            rem=n1%10;
            sum += (int) Math.pow(rem,3);
            n1/=10;
        }if (sum==n){
            System.out.println("its an arm strong number");
        }else {
            System.out.println("its not a arm strong number");
        }
        for (int i=100;i<=999;i++){
            int i1=i;
            while (i1!=0){
                rem=i1%10;
                sum += (int) Math.pow(rem,3);
                i1/=10;}

             if (sum==i) {
                 System.out.println(i);

             }else {
                 sum=0;

             }

        }
*/
/*
        String og= in.next();
        String re= " ";
        for (int i=og.length()-1;i>=0;i--){
            re+=og.charAt(i);

        }
        System.out.println(re.trim());
        if (og.equalsIgnoreCase(re.trim())){
            System.out.println("its a pallidrome");
        }else {
            System.out.println("not a pallidrome");
        }
*/

/*
        try{
            System.out.println("enter the char can be used in it");
            int n= in.nextInt();
            System.out.println("enter length of the passward");
            int r=in.nextInt();
            if (n>=r){
            System.out.println("the possible passward for ur case is"+permuation(n,r));

        }else {
            System.out.println("conditon n>r is not satified,where value  n is"+n+" and r value is"+r);

        }

        }catch (Exception e){
            System.out.println(e);
        }
*/
/*
        System.out.println("enter the persent value of the of share or invesment");
        float pv= in.nextFloat();
        System.out.println("enter the rate of growth of investment");
        float ra=in.nextFloat();
        System.out.println("enter of the year u are invested for");
        float ye=in.nextFloat();
        ra=(ra/100)+1;
        double fv=pv* (int)Math.pow(ra,ye);
        System.out.println("your future investment value will be "+fv+ " ruppes");
*/
/*
        System.out.println("enter the word");
        String  word=in.next();
        String vo="aeiou";
    int vo1=0;

    int con1=0;
    String vol=" ";
        String con="bcdfghjklmnpqrstvxyz";
        String conco=" ";
        for (int i=0;i<word.length();i++) {
            for (int j=0;j<vo.length();j++){
            if (word.charAt(i)==vo.charAt(j)) {
                vo1=vo1+1;
                vol=vol+word.charAt(i);

            }
            }for (int k=0;k<con.length();k++){
                if (word.charAt(i)==con.charAt(k)){
                    con1=con1+1;
                    conco=conco+word.charAt(i);
                }
            }



        }
        System.out.println("number of vowels are "+vo1);
        System.out.println("vowels are "+vol);
        System.out.println("number of consants are "+con1);
        System.out.println("consants are "+conco);

       */
/*
        System.out.println("enter the number ");
        try
        {int nu=in.nextInt();int re=0;
        for (int i=1;i<nu;i++){
            if (nu%i==0){
               re+=i;
            }
        }
        if (nu==re){
            System.out.println("its a perfect number");
        }else {
            System.out.println("its not a perfect number");
        }}catch (Exception e){
            System.out.println(e);
        }
*/
/*
        System.out.println("enter the number");
        int num=in.nextInt();
        int rem=0;
        int res=0;
        while (num!=0){
            rem=num%10;
            res+=rem;
            num/=10;

        }
        System.out.println("the sum of all digits in number is"+res);
*/
/*
        int num=31;int re=0;
        for (int i=1;i<=31;i++){
            if (i%2==0){
                re++;
            }
        }
        System.out.println("kunal these are the days u can go out "+re+" i know its bad but rules are rules");
*/

/*
        int neg=0;int pos=0;
       try
       {while (true){
            System.out.println("enter the number");
            int num=in.nextInt();
            if (num==0){
                break;
            }else if (num>0){
                pos+=num;
            }else {
                neg+=num;
            }
        }
        System.out.println("sum of all postive number is "+pos);
        System.out.println("sum of all negative nunmber is"+neg);}
       catch (Exception e){
           System.out.println(e);
           System.out.println("sum of all postive number till now is"+pos);
           System.out.println("sum of all negative number tiil now is"+neg);
       }
*/
/*
        int n;
        System.out.println("enter the size of the array");
        n=in.nextInt();
        int ele=in.nextInt();

        int arr[]=new int[n];
        for (int i=0;i<n;i++){
            System.out.println("enter the array in ascensding order");
            arr[i]=in.nextInt();

        }
*/
/*
        int beg=0,end=n-1;int mid;
        while (beg<=end){
            mid=(beg+end)/2;
            if (ele==arr[mid]){
                System.out.println("celling of the array is"+arr[mid]);
            }
            if (ele>arr[mid]){
                beg=mid+1;
            }else if(ele<arr[mid]) {
                end=mid-1;
            }
        }
        System.out.println("answer is "+arr[beg]);
        int a=(int)('a');
        int b=(int )('c');
        System.out.println(" "+a+" "+b);
*/
/*
        int []a={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        int ele=19;
        int start=0;
        int end=1;
        while (true){
        if (ele>a[end]){
       int newstart=end+1;
        end=(int)Math.pow(end+1,2);
        }else {
        while (start<=end){
            int mid =(start+end)/2;
            if (ele==a[mid]){
                System.out.println(+ele+"is found at postion"+mid);

            }
            if (ele>a[mid]){
                start=mid+1;
            }else {
                end=mid-1;
            }


        }
        break;
        }

        }
        System.out.println(a.length-8);

*/
/*
        int arr[]={3,5,3,2,0};
        int beg=0;
        int end=arr.length-1;

        while (beg<=end){
           int  mid=(beg+end)/2;
           if (beg!=mid){
           if ((arr[mid-1]<(arr[mid]))&&(arr[mid]>arr[mid+1])){
               System.out.println("peak value of the array is "+arr[mid]+" and at position "+mid);
               break;

           }}if (beg==mid){
               end=mid;

            }
           if ((arr[mid]<arr[mid+1])){
                beg=mid+1;

            }else {

                end=mid-1;


            }
        }
*/
/*
        System.out.println("enter the size of the array");
        int n = in.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the number of array ");

        for (int i = 0; i < arr.length; i++) {
            arr[i]=in.nextInt();

        }
      while (true) {

          if (n > 0) {

              System.out.println("enter the choice");
              System.out.println("1. display all elemenst ");
              System.out.println("2 sort all elements ");
              System.out.println("3. exit ");
              int ch =in.nextInt();
              switch (ch) {
                  case 1 -> System.out.println(Arrays.toString(arr));
                  case 2 -> {
                      sort(arr);

                      System.out.println(Arrays.toString(arr));
                  }
                  case 3 -> System.out.println("exiting");
                  default -> System.out.println("invailde input ");
              }
              if (ch==3){
                  break;
              }


          } else {
              System.out.println("enter the corecrt  size");

          }

      }
*/
       /* System.out.println("enter the three number");
        int []arr=new int[3];
        try{
        for (int i=0;i<3;i++) {
            arr[i]=in.nextInt();
        }
        System.out.println("largest is "+max(arr));
        System.out.println("smallest is "+min(arr));}
        catch (Exception e){
            System.out.println(e);
        }*/
       /* System.out.println("enter a number");
       try {
           identifer(in.nextInt());
       }
       catch (Exception e1){
           System.out.println(e1);
       }*/
        /*System.out.println("hi darling how are u ");
        System.out.println("enter ur age ");
        votingage(in.nextFloat());
*/
        /* int []arr=new int[3];
        try{
            for (int i=0;i<3;i++) {
                arr[i]=in.nextInt();
            }
            System.out.println("sum is  "+sum1(arr));
        }
        catch (Exception e){
            System.out.println(e);
        }*/
        /*System.out.println("enter the three number");
        int []arr=new int[3];
        try{
            for (int i=0;i<3;i++) {
                arr[i]=in.nextInt();
            }
            System.out.println("sum is  "+pro(arr));
        }
        catch (Exception e) {
            System.out.println(e);
        }*/
/*
       try{ System.out.println("enter the number");
        prime(in.nextInt());} catch (Exception e) {
           System.out.println(e);
       }
*/
/*
        System.out.println("hey buddy enter the ur marks out of 100");
        grade(in.nextFloat());
*/
        /*System.out.println("enter the factor ");
        fac(in.nextInt());
*/
      /*  System.out.println("enter the text or number to be checked");
        palin(in.next());*/
        /*System.out.println("enter the three number");
        triplet(in.nextInt(),in.nextInt(),in.nextInt());
*/
/*
       try {
           System.out.println("enter two till to revert the prime number");
           System.out.println(primeRetivere(in.nextInt(), in.nextInt()));
       } catch (Exception e) {
           System.out.println(e);
       }
*/
/*        System.out.println("enter till to be added");
        System.out.println("sum of the numbers is "+recursum(in.nextInt()));*/
       /* System.out.println("enter the number ");
        pattern1(in.nextInt());*/
/*        System.out.println("enter the number");
        pattern31(in.nextInt());
        */
      //  System.out.println("enter the number till to be printed  and pervious number of it ");
//    recu_1(in.nextInt(),in.nextInt());

        /*System.out.println(recursion_fib(in.nextInt()));
        System.out.println(fibonacci(in.nextInt()));*/
        /*System.out.println("input the number till the fib  shoud be printed");
        int n=in.nextInt();
       fib_usr(n);*/

        // assign of the codh

        /*Circle c1=new Circle(in.nextFloat());
         System.out.println(c1.area);*/
/*

        Rectangle r1=new Rectangle();
        System.out.println("enter the length of the rectangle ");
        r1.setLength(in.nextFloat());
        System.out.println("enter the bridth of the rectangle ");
        r1.setBridth(in.nextFloat());
        System.out.println(r1.area_rect());
        System.out.println(r1.permi_rect());
        Cuboid c1=new Cuboid();
        System.out.println("Enter the height,length and birdth of cuboid ");
        System.out.println(c1.area_cuboid(in.nextFloat(),in.nextFloat(),in.nextFloat()));
*/
        /*
        Ink_pen i1=new Ink_pen();
        i1.write();
        i1.refill();*/
/*
        Monkey m1=new Human();
        m1.getClass();
*/
        /*
        Basic_animals b1=new Human();
        b1.eat();b1.sleep();
*/
//        System.out.println("enter the number");
//        int n=in.nextInt();
//        int count=Integer.bitCount(n);
//        System.out.println(count);
//        System.out.println(n&(n-1));
//        int[][] arr1 = { {1,1,1}, {1,0,1}, {0,0,0} };
/*
        int row=0;
        System.out.println(arr[1]);

        // Using enhanced for loop
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }

        // Using traditional for loop
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
*/

//        System.out.println(Arrays.deepToString(arr));
//        System.out.println(isPrime(in.nextInt()));
//        System.out.println((int)Math.sqrt(17));
       /* for (int i = 1; i <40 ; i++) {
//            System.out.println(i+" "+isPrime(i));
            *//*if (isPrime(i)){
                System.out.println(i);
            }*//*

        }*/
      /*  assignments demo=new assignments();
       *//* System.out.println(demo.sumOfDigits(1342));
        System.out.println(demo.multiOfDigitd(1234));
        System.out.println(demo.reverseADigit(1342));
        System.out.println(demo.PallidromeInt(124321));*//*
        System.out.println(demo.countZeroS(10010));
        int []arr=new int[20];
*/
        /*int []arr=new int[6];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]= arr.length-i;
        }
//        Arrays.sort(arr);
        MergeSortUser.mergesortOP(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
*
         */
/*        printPattern(in.nextInt());
      System.out.println(gcd(36,60));
        separator("hello World ");*/

//        100184

        System.out.println("tea".hashCode());

    }
    /*private static void separator(String og){
       og=og.trim();
       og =og.toLowerCase();
        HashSet<Character>vowel=new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        int vowelCount=0;
        int consonantsCount=0;
        String v="{";
        String c="{";
        for (int i = 0; i <og.length(); i++) {
            char ch=og.charAt(i);
            if (!Character.isLetter(ch)) continue;
            if (vowel.contains(ch)){
                vowelCount++;
                v+=ch+" ";
            }else {
                consonantsCount++;
                c+=ch+" ";
            }
        }
        v+='}';
        c+="}";
        System.out.println(" these are vowel in the string "+v+" this is the count of them "+vowelCount);
        System.out.println(" these are consonants in the string "+c+" this is the count of them "+consonantsCount);
    }*/

/*    public static int gcdMY(int n,int n1){
        if (n==n1){
            return n;
        }
        if (n>n1){
            if (n1==0){
                return n;
            }
            return gcdMY(n1,n%n1);
        }else {
            if (n==0){
                return n1;
            }return gcdMY(n1%n,n);
        }
    }*/
/*    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int lcm(int a,int b){
        int gcd=gcd(a,b);
        return (a*b)/gcd;
    }
    */
    /*
        *
       ***
      *****
     *******
    *********
    */
    public static void printPattern(int n){
        for (int i = 0; i <n; i++) {
            int space=n-1-i;
            for (int k = 0; k <space; k++) {
                System.out.print(" ");
            }
            int stars=(2*i)+1;
            for (int j = 0; j <stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }



   /* public static boolean isPrime(int n){
        if (n<=3 && n>=2) return true;
        if ((n&1)==0)return false;
        if (n<2)return false;
        int c=2;
        while (c*c<=n){
            if (n%c==0)return false;
        c++;
        }return true;
    }*/



}
/*class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int []row:image){
            for (int i = 0; i <(image[0].length-1) ; i++) {
                int temp =row[i]^1;
                row[i]=row[image[0].length-i-1]^1;
                row[image[0].length-i-1]=temp;
            }
        }
        return image;
    }
}*/



