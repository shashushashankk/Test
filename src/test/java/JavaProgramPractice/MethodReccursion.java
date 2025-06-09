package JavaProgramPractice;

public class MethodReccursion {
    public static void main(String[] args) {
        int a =23;
        printEvenNumber(a);
    }
    static void printNumber(int endNum){
        if (endNum > 1){
            printNumber(endNum-1);
        }
        System.out.println(endNum);
    }
    static void printEvenNumber(double endNum){
        if(endNum==1){
            return;
        }
        if(endNum%2==0) {
            System.out.println(endNum);
        }
//        System.out.println("Entered inside the loop");
        printEvenNumber(--endNum);
    }
}