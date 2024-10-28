package OA.machines_questions;

public class Result1 {
    public long getTime(String s) {
        // Write your code here
            long total = 0;
            int currentPos = 0;
            for(char c : s.toCharArray()) {
                int pos = c - 'A';
                total += Math.min(Math.abs(pos - currentPos), currentPos > pos ? 26 - currentPos + pos : 26 - pos + currentPos);
                currentPos = pos;
            }
            return total;
        }
}
