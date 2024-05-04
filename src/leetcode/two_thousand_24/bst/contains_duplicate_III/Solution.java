package leetcode.two_thousand_24.bst.contains_duplicate_III;

import java.util.Comparator;

import java.util.PriorityQueue;

class Pair {
    public int val;
    public int idx;

    public Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

public class Solution {

    // bruteforce Solution
    // encounters TLE
    public boolean containsNearbyAlmostDuplicateV0(int[] nums, int indexDiff, int valueDiff) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                int currentIdxDiff = Math.abs(i - j);
                int currentValueDiff = Math.abs(nums[i] - nums[j]);
                if (currentIdxDiff <= indexDiff && currentValueDiff <= valueDiff) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        Comparator<Pair> valComparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p1.val, p2.val);
            }
        };
        PriorityQueue<Pair> pq = new PriorityQueue<>(valComparator);
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < (indexDiff + 1)) {
                pq.add(new Pair(nums[i], i));
            }
            if (pq.peek().idx != i && Math.abs(nums[i] - pq.peek().val) <= valueDiff) {
                return true;
            }
            if (pq.size() == (indexDiff + 1)) {
                pq.poll();
            }

        }
        return false;
    }
}

// 2 <= nums.length <= 105
// -109 <= nums[i] <= 109
// 1 <= indexDiff <= nums.length
// 0 <= valueDiff <= 109