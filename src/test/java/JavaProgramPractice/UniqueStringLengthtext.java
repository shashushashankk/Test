package JavaProgramPractice;

class UniqueStringLengthtext {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int count = 0;
        int maxCount = 0;
        String newStr = "";
        int stratindex = 0;
        int endIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            String val = s.charAt(i) + "";
            if (newStr.contains(val)) {
                int index = newStr.lastIndexOf(val);
                System.out.println("entered if condition");
                System.out.println("index of "+val+" is " + index);
                count = endIndex - stratindex + 1;
                if (maxCount < count) {
                    maxCount = count;
                }
                if(index>stratindex) {
                    stratindex = index + 1;
                }
                    endIndex = i;
            } else {
                System.out.println("entered else condition");
                endIndex++;
            }
            newStr += val;
            System.out.println("Start index is " + stratindex);
            System.out.println("End index  is " + endIndex);
            System.out.println("Count is " + count);
            System.out.println("Max count is " + maxCount);
        }
        count = endIndex - stratindex + 1;
        if (maxCount < count) {
            maxCount = count;
        }
        return maxCount;
    }
}