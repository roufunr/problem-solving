package leetcode.daily_challenge.september_25.number_of_people_aware_of_a_secret_09;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    private static final int MOD = 1_000_000_007;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        Deque<int[]> knowQueue = new LinkedList<>();
        Deque<int[]> shareQueue = new LinkedList<>();

        knowQueue.add(new int[] {1, 1});
        int knowingCount = 1;
        int sharingCount = 0;

        for (int day = 2; day <= n; day++) {
            if (!knowQueue.isEmpty() && knowQueue.peekFirst()[0] == day - delay) {
                int[] entry = knowQueue.pollFirst();
                knowingCount = (knowingCount - entry[1] + MOD) % MOD;
                sharingCount = (sharingCount + entry[1]) % MOD;
                shareQueue.add(entry);
            }

            if (!shareQueue.isEmpty() && shareQueue.peekFirst()[0] == day - forget) {
                int[] entry = shareQueue.pollFirst();
                sharingCount = (sharingCount - entry[1] + MOD) % MOD;
            }

            if (!shareQueue.isEmpty()) {
                knowingCount = (knowingCount + sharingCount) % MOD;
                knowQueue.add(new int[] {day, sharingCount});
            }
        }

        return (knowingCount + sharingCount) % MOD;
    }
}