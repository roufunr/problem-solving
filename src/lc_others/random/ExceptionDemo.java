package lc_others.random;

import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;

        Scanner scanner = new Scanner(System.in);
        int validCount = 0;
        while(validCount < 1) {
            try {
                a = scanner.nextInt();
                validCount++;
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Invalid Input");
            }
        }
        b = scanner.nextInt();

        System.out.println("Summation " + (a +b));
    }
}
