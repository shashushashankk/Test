package JavaProgramPractice;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class test {
    public static void main(String[] args) {
//        mutableString();
//        int[] arr = new int[15];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = generateRandomNumber();
//        }
//        int key = arr[7];
//        System.out.println(key);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(binerySearch(arr, key));
//        System.out.println(Arrays.toString(arr));
        arraysDeepString();
    }
    static void arraysDeepString(){
//        int arr[]={23,32,45,6,7};
        String arr[]={"23","32","45","6","7"};
        List list = Arrays.asList(arr);
//        arr.
        System.out.println(list.size());
        System.out.println(list);

    }
    static int generateRandomNumber(int start, int end) {
        Random random = new Random();
        return random.nextInt(start, end);
    }

    static int binerySearch(int[] arr, int key) {
        Arrays.sort(arr);
        int startLength = 0;
        int endLength = arr.length - 1;
        while (startLength < endLength) {
        int mid = (startLength+endLength)/ 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                startLength = mid + 1;
            } else {
                endLength = mid - 1;
            }
        }
        return -1;
    }

    static void arraysinbuiltfunc(int[] arr) {
        Arrays.fill(arr, 10, 15, 100);
    }

    static void arrayCopyOf(int[] arr) {
        Arrays.binarySearch(arr, 10, 15, 100);
    }

    static void mutableString() {
        StringBuilder a = new StringBuilder("25");
        StringBuilder b = (a);
        a.append("23");

        System.out.println(a);
        System.out.println(b);
    }

    static void teststring() {
        String a = new String("25");
        String b = new String(a);
        a = "50";

        System.out.println(a);
        System.out.println(b);
        int arr[] = {23, 4, 2, 1, 4, 556, 6};
        int arr1[] = arr;
        arr1[0] = 867;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }
}
