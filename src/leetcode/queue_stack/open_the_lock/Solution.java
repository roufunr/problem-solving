package leetcode.queue_stack.open_the_lock;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private String[] getAllPossibleState(String currentState) {
        char[] curStateArr = currentState.toCharArray();
        String[] nextPossibleStates = new String[8];
        for(int i = 0; i < curStateArr.length; i++) {
            int digit = curStateArr[i] - '0';
            int upDigit = digit == 9 ? 0 : (digit + 1);
            int downDigit = digit == 0 ? 9 : (digit - 1);
            //up
            char[] upState = currentState.toCharArray();
            upState[i] = (char)(upDigit + '0');
            //dowmn
            char[] downState = currentState.toCharArray();
            downState[i] = (char)(downDigit + '0');
            nextPossibleStates[i * 2] = new String(upState);
            nextPossibleStates[(i * 2) + 1] = new String(downState);
        }
        return nextPossibleStates;
    }

    public int openLock(String[] deadends, String target) {
        HashSet<String> deadset = new HashSet<>();
        for(String str : deadends) {
            deadset.add(str);
        }
        HashMap<String, Integer> visited = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        String startState = "0000";
        if(deadset.contains(startState)) {
            return -1;
        } else if(target.equals(startState)) {
            return 0;
        }
        visited.put(startState, 0);
        queue.add(startState);
        while(!queue.isEmpty()) {
            String currentState = queue.remove();
            int soFarDist = visited.get(currentState);
            String[] possibleNextStates = getAllPossibleState(currentState);
            for(String nextState : possibleNextStates) {
                if(deadset.contains(nextState) || visited.containsKey(nextState)) {
                    continue;
                } else if(nextState.equals(target)) {
                    return soFarDist + 1;
                } else {
                    queue.add(nextState);
                    visited.put(nextState, soFarDist + 1);
                }
            }
        }
        return -1;
    }
}
