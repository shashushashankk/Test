package JavaProgramPractice;

public class ReverseStringInAWord {
    public static void main(String[] args) {
        String sentense = "Shashank is an engineer";
//        System.out.println(reverseString(sentense));;
        System.out.println(reverseStringInAWordWithoutSplit(sentense));
        ;
    }

    public static String reverseStringInAWordWithoutSplit(String val) {
        char[] arr = val.toCharArray();
        String result = "";
        int firstIndex = 0;
        int lastIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            char character = arr[i];
            boolean isSpace = Character.isWhitespace(character);
            if (isSpace || (i + 1) == arr.length) {
                lastIndex = i;
                String newString = val.substring(firstIndex, lastIndex + 1);
                result += reverseString(newString) + "";
                result += " ";
                firstIndex = lastIndex;
            }

        }
        return result.trim();
    }

    public static String reverseString(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result.trim();
    }
}
