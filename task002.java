import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class task002 {

    public static void main(String[] args) {
        
        String first = "фамилия : Иванов, оценка : 5, предмет : Математика";
        String second = "фамилия : Петрова, оценка : 4, предмет : Информатика";
        String third = "фамилия : Краснов, оценка : 5, предмет : Физика";
        System.out.println(BuildLine(JsonParser(first)));
        System.out.println(BuildLine(JsonParser(second)));
        System.out.println(BuildLine(JsonParser(third)));

        
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getAnonymousLogger();
        ArrayList <Integer> randomArray = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            randomArray.add(ThreadLocalRandom.current().nextInt(1, 10));
        }

        FileHandler fh;  
        try {

            fh = new FileHandler("log.txt");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        } 
        catch (Exception e) {
            System.out.println("Error");
        }
    
        logger.info(randomArray.toString());
        logger.info(BubbleSort(randomArray, logger).toString());

        System.out.println(Calc(4, 7, "/", logger));


        File directoryPath = new File("HW_java");
        String contents[] = directoryPath.list();
        String element =new String();
        for (int i = 0; i < contents.length; i++) {
            element = contents[i].substring(contents[i].lastIndexOf('.'));
            System.out.println(String.join(" ", element ));
        }


    }
    
    public static Map JsonParser(String person) {
        Map<String, String> parsedMap = new HashMap<String, String>();
        String[] lines = person.split(",");
        String[] substring = null;
        for (String keyString : lines) {
            substring = keyString.split(":");
            parsedMap.put(substring[0].trim(), substring[1].trim());
        }
        return parsedMap;
    }

    public static StringBuilder BuildLine(Map<String, String> parsed) {
        StringBuilder myCuteUwUBuilder = new StringBuilder();
        myCuteUwUBuilder.append(parsed.get("фамилия"));
        myCuteUwUBuilder.append(" получил ");
        myCuteUwUBuilder.append(parsed.get("оценка"));
        myCuteUwUBuilder.append(" по предмету ");
        myCuteUwUBuilder.append(parsed.get("предмет"));
        return myCuteUwUBuilder;
    }

    public static ArrayList<Integer> BubbleSort(ArrayList<Integer> someArray, Logger logger) {

        for (int i = 0; i < someArray.size(); i++) {
            for (int j = 1; j < someArray.size(); j++) {
                if (someArray.get(j) < someArray.get(j - 1)) {
                    Collections.swap(someArray, j, j - 1);
                    logger.info(someArray.toString());
                }
            }

        }
        return someArray;

    }

    
    public static float Calc(float a, float b, String oper, Logger logger) {
        switch (oper) {
            case "+": {
                logger.info(String.valueOf(a+b));
                return a + b;
            }
            case "-": {
                logger.info(String.valueOf(a - b));
                return a - b;
            }
            case "*":{
                logger.info(String.valueOf(a * b));
                return a*b;
            }
            case "/":
                if (b == 0) {
                    System.out.println("Division by zero");
                    return 0f;
                }
                else{
                    logger.info(String.valueOf(a/b));
                    return a/b;
                }
            case "**":
                return (float) Math.pow(a, b);
        }
        return 0f;
    }
}