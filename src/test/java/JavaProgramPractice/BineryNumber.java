package JavaProgramPractice;


public class BineryNumber {
    public static void main(String[] args) {
        int random = (int) (Math.random() * 10);
//        System.out.println(random);
//        System.out.println("The binery number is "+numberToBiner(test.generateRandomNumber(0,10)));
        System.out.println("The binery number is " + numberToBinerReccurssion(18));
    }

    static int numberToBiner(int num) {
        System.out.println("number is " + num);
        StringBuilder res = new StringBuilder();
        int val;
        while (num > 0) {
            val = num % 2;
            res.insert(0, val);
            num /= 2;
        }
        System.out.println(res);
        return Integer.parseInt(String.valueOf(res));
    }

    static String numberToBinerReccurssion(int num) {
        String bineryNumb = "";
        if (num == 0) {
            return "";
        }
        if (num > 0) {
            bineryNumb += numberToBinerReccurssion(num / 2);
        }
        bineryNumb += num % 2;
        return bineryNumb;
    }
}
