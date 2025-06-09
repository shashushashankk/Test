package JavaProgramPractice;

public class CountUppercaseLowercase {
    public static void main(String[] args) {
        countCase("890dscxsuh 9cx9i 0i9usixckasokcp 8909(*)(*&^Rxuy iusytc7");
    }

    static void countCase(String str) {
        int upperLettercount = 0, lowerLettterCount = 0, specialChar = 0, number = 0;
        for (int i = 0; i < str.length(); i++) {
            char val = str.charAt(i);
            if (val >= 65 && val <= 90) {
                upperLettercount++;
            } else if (val >= 97 && val <= 122) {
                lowerLettterCount++;
            } else if (val >= 48 && val <= 57) {
                number++;
            } else {
                specialChar++;
            }
        }
            System.out.println("special charecter count is "+specialChar);
            System.out.println("Upper charecter count is "+upperLettercount);
            System.out.println("Lower charecter count is "+lowerLettterCount);
            System.out.println("Number charecter count is "+number);

        return;
    }
}
