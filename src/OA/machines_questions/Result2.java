package OA.machines_questions;

public class Result2 {
    public int complement(int num) {
        int bitLength = Integer.toBinaryString(num).length();
        int mask = 1 << bitLength;
        mask--;
        return num ^ mask;
    }
    public int maxXor(int lo, int hi, int k) {
    // Write your code here
        int ans = Integer.MIN_VALUE;
        for(int i = k; i >= 0; i++) {
            for(int j = lo; j <= hi; j++) {
                if((i ^ j) <= k) {
                    ans = Math.max(ans, i ^ j);
                }
            }
        }
        return ans;
    }
}
