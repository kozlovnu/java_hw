import java.util.Scanner;

/**
 * task001_1
 */
public class task001_1 {
    public static void main (String[] args){
        System.out.println("Enter your number: ");
        Scanner Scan = new Scanner(System.in);
        int n = Scan.nextInt();
        int result_sum = 0;
        int result_n = 1;
        for (int i = 0; i<=n; i++){
            result_sum = result_sum + i;
        }
        System.out.println("n-triangle number is " + result_sum);
        for (int i = 1; i <= n; i++){
            result_n = result_n * i;
        }
        System.out.println("factorial of is " + result_n);
    }
    
}