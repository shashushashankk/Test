package JavaProgramPractice;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class WordToNumber {
    public static void main(String[] args) {
        long amount = worldToNumber("eleven crore thirty three");
        System.out.println(convertFormate(amount));
    }

    static int worldToNumber(String text) {
        int amount = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);
        map.put("eleven", 11);
        map.put("twelve", 12);
        map.put("thirteen", 13);
        map.put("fourteen", 14);
        map.put("fifteen", 15);
        map.put("sixteen", 16);
        map.put("seventeen", 17);
        map.put("eighteen", 18);
        map.put("nineteen", 19);
        map.put("twenty", 20);
        map.put("thirty", 30);
        map.put("fourty", 40);
        map.put("fifty", 50);
        map.put("sixty", 60);
        map.put("seventy", 70);
        map.put("eighty", 80);
        map.put("ninety", 90);
        map.put("hundred", 100);
        map.put("thousand", 1000);
        map.put("lakh", 100000);
        map.put("million", 100000);
        map.put("crore", 10000000);
        map.put("billion", 100000000);
        String[] arr = text.split(" ");
        boolean isContains;
        int previousNumber = 1;
        for (String val : arr) {
            val = val.toLowerCase();
            isContains = map.containsKey(val);
            if (isContains) {
                int number = map.get(val);
                System.out.println("Number is " + number);
                if (val.equals("hundred") || val.equals("thousand") || val.equals("lakh") || val.equals("million") || val.equals("crore") || val.equals("billion")) {
                    amount -= previousNumber;
                    amount += (previousNumber * number);
                } else {
                    amount += number;
                }
                previousNumber = number;
                System.out.println("amount is " + amount);
            } else {
                return -1;
            }
        }

        return amount;
    }

    static String convertFormate(long number) {
        DecimalFormat indianFormat = new DecimalFormat("#,##,##,###");

        String formattedNumber = indianFormat.format(number);

        System.out.println("Formatted Number: " + formattedNumber);

        return formattedNumber;
    }
}
