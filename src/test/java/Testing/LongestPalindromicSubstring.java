package Testing;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
//        String input = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(isPalidrome("s"));
        String input = "babad";
        System.out.println("Longest Palindromic Substring: " + longestPalindromeOwn(input));
//        System.out.println("Longest Palindromic Substring: " + longestPalindrome(input));
    }

    public static String longestPalindromeOwn(String s) {

        String maxPalidrome = "";
        String res = "";
        if (s == null || s.length() <= 0) {
            res.substring(1,2);
            return "";
        } else if (s.length() == 1) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
//            System.out.println("Entered outer loop");
            res = s.charAt(i) + "";
            for (int j = i + 1; j < s.length(); j++) {
//            System.out.println("Entered inner loop");
                res += s.charAt(j);
                System.out.println(res + " is Palidrome "+isPalidrome(res));
                if (isPalidrome(res)) {
                    if (maxPalidrome.length() < res.length()) {
                        maxPalidrome = res;
                    }
                } else {
//                    break;
                }
            System.out.println(res);
            }
//            System.out.println(maxPalidrome);
        }
        if (maxPalidrome.equals("")) {
            return s.charAt(0) + "";
        }
        return maxPalidrome;
    }

    public static boolean isPalidrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // Odd-length palindrome
            int len2 = expandAroundCenter(s, i, i + 1); // Even-length palindrome
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
