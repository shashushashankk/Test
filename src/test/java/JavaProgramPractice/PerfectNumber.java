package JavaProgramPractice;

import java.util.Scanner;

public class PerfectNumber {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int j=0;
        do {
            System.out.println("Do while test");
            j++;
        } while (j<10);

        for (int i = 1; i <= 10; i++) {
            int rand = sc.nextInt();
            boolean isPerfect = isPerfectNumber(rand);
            String res = isPerfect ? rand + " The number is perfect number" : rand + " not a prfect number";
            System.out.println(res);
        }
    }

    static boolean isPerfectNumber(int number) {
        boolean isPerfect = false;
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        isPerfect = number == sum ? true : false;
        return isPerfect;
    }
}
