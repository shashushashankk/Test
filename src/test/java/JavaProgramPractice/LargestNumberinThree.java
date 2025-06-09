package JavaProgramPractice;

public class LargestNumberinThree {
    public static void main(String[] args) {
        int a = 23, b = 12, c = 43;
        if (a > b) {
            if (a > c) {
                System.out.printf("largest number is " + a);
            } else {
                System.out.printf("largest number is " + c);
            }
        } else {

            if (b > c) {
                System.out.printf("largest number is " + b);
            } else {
                System.out.printf("largest number is " + c);
            }
        }
    }
}
