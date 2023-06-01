package leetcode.binary_search.guess_number_higher_or_lower;

public class GuessGame {
    private int pick;
    public GuessGame(int range) {
        pick = (int)Math.floor(Math.random() * range + 1);
        System.out.println("Picked: " + pick);
    }
    public int guess(int num) {
        if(num > pick) {
            return -1;
        } else if(num < pick) {
            return 1;
        } else {
            return 0;
        }
    }
}
