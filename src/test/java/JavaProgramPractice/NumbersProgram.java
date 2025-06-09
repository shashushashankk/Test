package JavaProgramPractice;

import java.util.Scanner;

    public class NumbersProgram {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
    //        System.out.println("number is "+number);
    //        System.out.println("Factorial is "+factorialSingleNumber(number));
            String result = isArmStrong(number) ? "Given number is a arm strong number" : "The given number is not an arm strong number";
            System.out.println(result);
            sc.close();
        }

        static boolean isArmStrong(int number) {
            boolean isArmStrong = false;
            int expected = number;
            int actual = 0;
            if (number < 0) {
                return false;
            }
            int count = countDigits(number);
            System.out.println("count is "+count);
            while (number > 0) {
                int singleValue = number % 10;
                actual += Math.pow(singleValue, count);
                number/=10;
            }
            if (actual == expected) {
                isArmStrong = true;
            }

            return isArmStrong;
        }

    static int countDigits(int number) {
        int count=0;
        while (number>0){
            count++;
            number/=10;
        }
        return count;
    }
    static boolean isStrongNumber(int number) {
        boolean isStrong = false;
        int expected = number;
        int actualNumber = 0;
        if (number < 0) {
            return false;
        }
        while (number > 0) {
            actualNumber += factorialSingleNumber(number % 10);
            number /= 10;
        }
        if (actualNumber == expected) {
            isStrong = true;
        }
        return isStrong;

    }

    static int factorialSingleNumber(int number) {
        int fact = number;
        if (number == 0 || number == 1) {
            return 1;
        } else if (number < 0) {
            return -1;
        }
        for (int i = 1; i < number; i++) {
            fact *= i;
        }
        return fact;
    }
}
