package leetcode.daily_challenge.january_25.make_lexicographically_smallest_array_by_swapping_elements_25;

import java.util.*;

public class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        List<Deque<Integer>> listOfGroups = new ArrayList<>();
        Map<Integer, Integer> elementGroupMap = new HashMap<>();
        listOfGroups.add(new LinkedList<>());
        listOfGroups.get(0).offer(sortedNums[0]);
        elementGroupMap.put(sortedNums[0], 0);
        for (int i = 1; i < sortedNums.length; i++) {
            int currentGroupLastElemet = listOfGroups.get(listOfGroups.size() - 1).peekLast();
            int currentVal = sortedNums[i];
            if (currentVal - currentGroupLastElemet > limit) {
                listOfGroups.add(new LinkedList<>());
            }
            listOfGroups.get(listOfGroups.size() - 1).offer(currentVal);
            elementGroupMap.put(currentVal, listOfGroups.size() - 1);
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = listOfGroups.get(elementGroupMap.get(nums[i])).pollFirst();
        }
        return ans;
    }
}