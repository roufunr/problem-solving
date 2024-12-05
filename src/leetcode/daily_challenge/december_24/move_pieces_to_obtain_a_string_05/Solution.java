package leetcode.daily_challenge.december_24.move_pieces_to_obtain_a_string_05;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean canChange(String start, String target) {
        List<int[]> startList = new ArrayList<>();
        for(int i = 0; i < start.length(); i++) {
            if(start.charAt(i) == '_') {
                continue;
            } else if(start.charAt(i) == 'L') {
                startList.add(new int[]{i, 0});
            } else {
                startList.add(new int[]{i, 1});
            }
        }

        int j = 0;
        for(int i = 0; i < target.length(); i++) {
            if(target.charAt(i) == '_') {
                continue;
            } else if(target.charAt(i) == 'L') {
                if(j >= startList.size()) {
                    return false;
                }
                if(startList.get(j)[1] != 0) {
                    return false;
                } else if (startList.get(j)[0] < i){
                    return false;
                }
                j++; 
            } else {
                if(j >= startList.size()) {
                    return false;
                }
                if(startList.get(j)[1] != 1) {
                    return false;
                } else if (startList.get(j)[0] > i){
                    return false;
                }
                j++;
            }
        }
        if(j != startList.size()) {
            return false;
        }
        return true;
    }
}