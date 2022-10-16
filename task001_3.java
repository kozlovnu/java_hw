// Реализовать простой калькулятор
import java.util.Scanner;
import java.util.*;


public class task001_3 {
    public static void main (String[] args){
        Calc();
    }

    public static void Calc(){
        System.out.println("Enter expression:");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String[] output;
        output = line.split("");
        float result = 0;

        for (int i = 0; i<output.length; i++){
            // System.out.println(output[i]);

            switch(output[i]){
                case "+":
                    result = Float.parseFloat(output[i-1]) + Float.parseFloat(output[i+1]);
                    System.out.println("result is " + result);
                    break;
                case "-":
                    result = Float.parseFloat(output[i-1]) - Float.parseFloat(output[i+1]);
                    System.out.println("result is " + result);
                    break;
                case "*":
                result = Float.parseFloat(output[i-1]) * Float.parseFloat(output[i+1]);
                System.out.println("result is " + result);
                break;
                case "/":
                    if (Integer.parseInt(output[i+1]) != 0){
                        result = Float.parseFloat(output[i-1]) / Float.parseFloat(output[i+1]);
                        System.out.println("result is " + result);
                        break;
                    }
                    else{
                        System.out.println("Division by zero");
                    }
                    
            }
        }
    }

}
