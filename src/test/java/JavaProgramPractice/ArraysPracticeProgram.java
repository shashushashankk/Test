package JavaProgramPractice;

import java.util.Arrays;

public class ArraysPracticeProgram {
    public static void main(String[] args) {
        int[] arr = ArraysPgm.createArrayWithRandom(20);
        System.out.println("Array is " + Arrays.toString(arr));
//        System.out.println(largestElement(arr));
//        System.out.println("Reversed array is " + Arrays.toString(reverseArrayInGroups(arr, 3)));
//        System.out.println("new array " + Arrays.toString(moveZeroToEnd(arr)));
//        System.out.println("new array " + Arrays.toString(removeDuplicateBySorting(arr)));
        System.out.println("new array " + Arrays.toString(removeDuplicateWithoutSorting(arr)));
    }

    static int[] removeDuplicateWithoutSorting(int[] arr) {
        int length = arr.length;
        int[] newArr = new int[length];
        int index = 0;
        for (int i = 0; i < length; i++) {
            boolean isContains = false;
            for (int j = 0; j < index; j++) {
                if (arr[i] == newArr[j]) {
                    isContains = true;
                    break;
                }
            }
            if (!isContains) {
                newArr[index++] = arr[i];
            }
        }
        return newArr;
    }

    static int[] removeDuplicateBySorting(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        int uniqueIndex = 0;
        System.out.println(Arrays.toString(newArr));
        for (int i = 1; i < newArr.length - 1; i++) {
            if (newArr[i] != newArr[uniqueIndex]) {
                uniqueIndex++;
                newArr[uniqueIndex] = newArr[i];
            }
        }
        System.out.println("new length is " + uniqueIndex);
        return Arrays.copyOf(newArr, uniqueIndex);
    }

    static int[] moveZeroToEnd(int[] arr) {
        int index = 0;
        for (int val : arr) {
            if (val == 0) {
                continue;
            } else {
                arr[index] = val;
                index++;
            }
        }
        while (index < arr.length) {
            arr[index] = 0;
            index++;
        }
        return arr;
    }

    static int[] reverseArrayInGroups(int[] arr, int k) {
        int[] result = new int[arr.length];
        int initialValue = 0;
        int groupSize = k;
        int count = 0;
        while (count < 1) {
//            System.out.println("En
//            tered while loop");
//            System.out.println("K size is "+k);
            result = reverseArray(arr, initialValue, k);
//            System.out.println("Result is "+Arrays.toString(result));
            initialValue = k;
            k += groupSize;
            if (k > arr.length) {
                k = arr.length;
                count++;
            }
        }
        return result;
    }

    static int[] reverseArray(int[] arr, int initialValue, int finalValue) {
        finalValue -= 1;

        while (initialValue < finalValue) {
            int temp = arr[initialValue];
            arr[initialValue] = arr[finalValue];
            arr[finalValue] = temp;
//            System.out.println("Reversed array successfully");
            initialValue++;
            finalValue--;
        }
        return arr;
    }

    static int largestElement(int[] arr) {
        int largestNumber = arr[0];
        for (int number : arr) {
            if (largestNumber < number) {
                largestNumber = number;
            }
        }
        return largestNumber;
    }
}
