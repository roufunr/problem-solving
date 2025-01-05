package leetcode.daily_challenge.january_25.shifting_letters_ii_05;

public class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] arr = new int[s.length()];
        int[] prefixArr = new int[arr.length + 1];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int)(s.charAt(i) - 'a');
        }
        for(int[] shift : shifts) {
            prefixArr[shift[1] + 1] += shift[2] == 0 ? (-1) : 1;
            prefixArr[shift[0]] += shift[2] == 0 ? 1 : (-1);
        }
        int diff = 0;
        for(int i = prefixArr.length - 1; i > 0; i--) {
            diff = (diff + prefixArr[i] + 26) % 26;
            arr[i - 1] = (arr[i - 1] + diff + 26) % 26;
        } 
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            sb.append((char)('a' + arr[i]));
        }
        return sb.toString();
    }
}
