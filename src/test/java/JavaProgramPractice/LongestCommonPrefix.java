package JavaProgramPractice;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        byte sample = (byte) (127*2);
        System.out.println("Sample is "+sample);
//        String[] strs = {"flower", "flow", "flight"}; // Example array of strings
//        String longestPrefix = longestCommonPrefix(strs);
//        System.out.println("Longest common prefix: " + longestPrefix);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return ""; // If the array is empty or null, return an empty string
        }
        String prefix = strs[0]; // Initialize prefix with the first string in the array
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1); // Reduce prefix length until it matches
                if (prefix.isEmpty()) {
                    return ""; // If prefix becomes empty, return an empty string
                }
            }
        }
        return prefix; // Return the longest common prefix
    }
}