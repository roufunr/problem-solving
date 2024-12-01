package lc_others.complex_number_multiplication;

public class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int a1 = Integer.parseInt(num1.split("\\+")[0]);
        int a2 = Integer.parseInt(num2.split("\\+")[0]);
        int b1 = Integer.parseInt((num1.split("\\+")[1]).substring(0, (num1.split("\\+")[1]).length() - 1));
        int b2 = Integer.parseInt((num2.split("\\+")[1]).substring(0, (num2.split("\\+")[1]).length() - 1));
        int m = a1 * a2 - b1 * b2;
        int n = a1 * b2 + a2 * b1;
        return m + "+" + n + "i";
    }
}