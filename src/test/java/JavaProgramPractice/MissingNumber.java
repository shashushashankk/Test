package JavaProgramPractice;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 2, 7, 9, 6, 4}; // Example array
        int missing = findMissingNumber(nums);
        System.out.println("The missing number is: " + missing);
    }

    public static int findMissingNumber(int[] nums) {
        int n = nums.length+1;
        // Calculate the expected sum of numbers from 0 to n
        int expectedSum = (n + 1) * n / 2;
        // Calculate the actual sum of numbers in the array
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        // The missing number is the difference between the expected sum and the actual sum
        return expectedSum - actualSum;
    }
}