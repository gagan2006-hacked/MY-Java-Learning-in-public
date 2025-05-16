
import java.util.Scanner;
public class Main {
    private static System system ;

    public static void main(String[] args) {
        Scanner sc=new Scanner(system.in);
        System.out.println("enter the monthly salary");
        int sl= sc.nextInt();
        if (sl>=10000){
            sl = sl +2000;
        }else {
            sl =sl +1000;

        }
        System.out.print("ur total salary is ");
        System.out.print(sl);
    }
}