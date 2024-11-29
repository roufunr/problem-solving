package lc_others.make_array_elements_equal_0;
import java.util.*;
public class Solution {
    private boolean allZero(int[] nums) {
        for(int n : nums) {
            if(n != 0) {
                return false;
            }
        }
        return true;
    }
    public int countValidSelections(int[] nums) {
        int[] directions = {1, -1};
        List<Integer> zeroItemIdx = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zeroItemIdx.add(i);
            }
        }
        int validCount = 0;
        for(int idx : zeroItemIdx) {
            for(int dir : directions) {
                int curDir = dir;
                int[] cNums = new int[nums.length];
                for(int i = 0; i < nums.length; i++) {
                    cNums[i] = nums[i];
                }
                int cur = idx;
                while(cur >= 0 && cur < nums.length) {
                    if(cNums[cur] == 0) {
                        cur += curDir;
                    } else {
                        cNums[cur]--;
                        curDir *= (-1);
                        cur += curDir;
                    }
                }
                if(allZero(cNums)) {
                    validCount++;
                }
            }
        }
        return validCount;
    }
}