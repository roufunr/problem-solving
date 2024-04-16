package leetcode.two_thousand_24.trie.max_xor;

class Node {
    public Node zero;
    public Node one;
}

public class Solution {
    private Node root;

    public Solution() {
        root = new Node();
    }

    private void insert(int value) {
        Node itr = root;
        for (int i = 31; i >= 0; i--) {
            int ithBit = (value >> i) & 1;
            if (ithBit == 0) {
                if (itr.zero == null) {
                    itr.zero = new Node();
                }
                itr = itr.zero;
            } else {
                if (itr.one == null) {
                    itr.one = new Node();
                }
                itr = itr.one;
            }
        }
    }

    public int calculateXOR(int value) {
        int ans = 0;
        Node itr = root;
        for (int i = 31; i >= 0; i--) {
            int ithBit = (value >> i) & 1;
            if (ithBit == 0) {
                if (itr.one != null) {
                    ans += (1 << i);
                    itr = itr.one;
                } else {
                    itr = itr.zero;
                }

            } else {
                if (itr.zero != null) {
                    ans += (1 << i);
                    itr = itr.zero;
                } else {
                    itr = itr.one;
                }
            }
        }
        return ans;
    }

    public int findMaximumXOR(int[] nums) {
        int max = 0;
        insert(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int xorValue = calculateXOR(nums[i]);
            if (max < xorValue) {
                max = xorValue;
            }
            insert(nums[i]);
        }
        return max;
    }
}