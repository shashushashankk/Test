package Pattern;

public class Pattern {
    public static void main(String[] args) {
        triangleNumb(4);
    }


    static void triangleNumb(int height) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= height; j++) {
                if (i >= j) {
                    System.out.print(j);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void plusStar(int boxSize) {
        int mid = boxSize / 2 + 1;
        ;

        for (int i = 1; i <= boxSize; i++) {
            for (int j = 1; j <= boxSize; j++) {
                if (i == mid || j == mid) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    static void printNumber(int boxSize, int endNumber) {
        int num = 1;
        for (int i = 1; i <= boxSize; i++) {
            for (int j = 1; j <= boxSize; j++) {
                if (num > endNumber) {
                    num = 0;
                }
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

    static void printNumAndAlpha(int length) {
        int num = 1;
        char alpha = 'a';
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                if (j % 2 == 1) {
                    System.out.print(num + " ");
                    num++;
                } else {
                    System.out.print(alpha + " ");
                    alpha++;
                }
            }
            System.out.println();
        }
    }

    static void boxNumbCAlpha(int length) {
        for (int i = 1; i <= length; i++) {
            int number = 1;
            char alpha = 'A';
            for (int j = 1; j <= length; j++) {
                if (i % 2 == 1) {
                    System.out.print(number + " ");
                    number++;
                } else {
                    System.out.print(alpha + " ");
                    alpha++;
                }
            }
            System.out.println();
        }
    }

    static void boxStart(int length) {
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void boxNumb(int length) {
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static void boxAlpha(int length) {
        char alpha = 96 + 1;
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                System.out.print(alpha + " ");
            }
            alpha++;
            System.out.println();
        }
    }

    static void PrintEven(int length) {
        for (int i = 1; i <= length; i++) {
            if (i % 2 == 0) {
                for (int j = 1; j <= length; j++) {
                    if (j % 2 == 0) {
                        System.out.print(j + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}
