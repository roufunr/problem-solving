package lc_others.length_of_last_word;

public class SolutionII {

    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int count = 0;
        for (; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
                continue;
            }
            if (count > 0 && s.charAt(i) == ' ') {
                break;
            }
        }
        return count;
    }

}
