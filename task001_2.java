// Вывести все простые числа от 1 до 1000
import java.util.ArrayList;

public class task001_2 {
    public static void main (String[] args){
        PrimeRange(1, 1000);
    }
    public static void PrimeRange(int low, int up) {
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = low; i < up + 1; i++) {
            long upperDiv = Math.round((Math.sqrt(i)));
            boolean flag = true;
            for (int j = 2; j < upperDiv + 1; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                output.add(i);

            flag = true;

        }
        if (output.get(0) == 1)
            output.remove(0);

        System.out.println(output.toString());
    }
}
