package leetcode.top150.valid_palindrome_25;

public class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                int smallC = (c - 'A') + 'a';
                sb.append((char)smallC);
            } else if(c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if(c >= '0' && c <= '9') {
                sb.append(c);
            } else {
                continue;
            }
        }
        for(int i = 0; i < (sb.length()/2); i++) {
            if(sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
