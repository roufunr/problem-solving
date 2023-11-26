package leetcode.random.three_sum_to_0;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            Set<Integer> pairCheckSet = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int thirdInt = ((-1) * target) - nums[j];
                if (pairCheckSet.contains(thirdInt)) {
                    int[] tripletArr = { target, nums[j], thirdInt };
                    Arrays.sort(tripletArr);
                    String triplet = tripletArr[0] + "_" + tripletArr[1] + "_" + tripletArr[2];
                    if (!set.contains(triplet)) {
                        set.add(triplet);
                    }
                } else {
                    pairCheckSet.add(nums[j]);
                }
            }
        }
        for (String triplet : set) {
            String[] numStrArr = triplet.split("_");
            List<Integer> tripletList = new ArrayList<>();
            for (String num : numStrArr) {
                tripletList.add(Integer.parseInt(num));
            }
            ans.add(tripletList);
        }

        return ans;
    }
}