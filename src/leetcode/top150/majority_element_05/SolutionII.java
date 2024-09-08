package leetcode.top150.majority_element_05;


// Solved the majority element using bit manipulation
// Space complexity O(1)
public class SolutionII {
    public int majorityElement(int[] nums) {
        int majority = 0;
        for(int i = 0; i < 32; i++) {
            int bit = 1 << i;
            int bitCount = 0;
            for(int num : nums) {
                if((num & bit) != 0) {
                    bitCount++;
                }
            }
            if(bitCount > (nums.length / 2)) {
                majority |= bit;
            }
        }
        return majority;
    }
}
