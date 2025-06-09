package JavaProgramPractice;

public class ArraysPgm {
    public static void main(String[] args) {
        int arr[] = createArrayWithRandom(15);
//        System.out.println(largestNumber(arr));
        System.out.println(args.length);
        printArray(args);
    }

    static int largestNumber(int arr[]) {
        int largestNum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (largestNum < arr[i]) {
                largestNum = arr[i];
            }
        }
        return largestNum;
    }

    static int sumOfNumbers(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    static void printEvenNumber(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                System.out.println(arr[i]);
        }
    }

    static int[] createArrayWithRandom(int size) {
        int arr[] = new int[size];
        for (int i = 0; i < arr.length; i++) {
            int val = test.generateRandomNumber(0,100);
            arr[i] = val;
        }
        return arr;
    }

    static void printArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
