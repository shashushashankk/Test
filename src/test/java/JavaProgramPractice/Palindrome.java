package JavaProgramPractice;

public class Palindrome {
    public static void main(String[] args) {
        isNumberPalidrome(121);
        System.out.println( countEvenDigit(1263));
    }
    static void isNumberPalidrome(int number){
        int expected = number;
        int actual =0;
        while (number>0){
            actual=actual*10+(number%10);
            number/=10;
        }
        if (actual==expected){
            System.out.println("Given number is palidrome");
        }else {
            System.out.println("Given number is not a palidrome");
        }
    }
    static  int countEvenDigit(int number){
        int count=0;
        while (number>0){
            int val =number%2;
            if (val==0){
                count++;
            }
            number/=10;
        }
        return  count;
    }
}

