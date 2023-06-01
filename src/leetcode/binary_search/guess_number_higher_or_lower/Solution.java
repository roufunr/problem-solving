package leetcode.binary_search.guess_number_higher_or_lower;
//https://leetcode.com/explore/learn/card/binary-search/125/template-i/951/
public class Solution extends GuessGame{
    public Solution(int range) {
        super(range);
    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int mid;
        do {
            mid = left + (right - left)/2;
            if(guess(mid) == 0) {
                break;
            } else if (guess(mid) == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        } while (left <= right);
        System.out.println("found: " + mid);
        return mid;
    }
}
