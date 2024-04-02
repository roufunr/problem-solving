package leetcode.two_thousand_24.recursion.kth_symbol;

public class Solution {
    private int n;
    private int k;

    private int calculate(int currentRow, int currentValue, int searchSpace) {
        if(currentRow == n) {
            return currentValue;
        }
        if(k <= (searchSpace/2)) {
            return calculate(currentRow + 1, currentValue == 0?0:1, searchSpace/2);
        } else {
            this.k = this.k - (searchSpace/2);
            return calculate(currentRow + 1, currentValue == 0?1:0, searchSpace/2);
        }
    }
    public int kthGrammar(int n, int k) {
        this.n = n;
        this.k = k;
        int ans = calculate(1, 0, (int)Math.pow(2, n-1));
        return ans;
    }
}
