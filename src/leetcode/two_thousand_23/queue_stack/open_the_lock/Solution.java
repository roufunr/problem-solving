package leetcode.two_thousand_23.queue_stack.open_the_lock;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for(String deadend : deadends) {
            set.add(deadend);
        }
        String startState = "0000";
        Queue<String> queue = new LinkedList<>();
        queue.offer(startState);
        map.put(startState, 0);
        while (!queue.isEmpty()) {
            String poppedState = queue.poll();
            char[] poppedStateDigits = poppedState.toCharArray();
            for(int i = 0; i < poppedStateDigits.length; i++) {
                char nextDigit = (char)((((poppedStateDigits[i] - '0') + 1)%10) + '0');
                char prevDigit = (char)((((poppedStateDigits[i] - '0') - 1 + 10)%10) + '0');

                poppedStateDigits[i] = nextDigit;
                String nextString = new String(poppedStateDigits);

                poppedStateDigits[i] = prevDigit;
                String prevString = new String(poppedStateDigits);

                if(nextString.equals(target) || prevString.equals(target)) {
                    return map.get(poppedState) + 1;
                }

                if(!set.contains(nextString) && !map.containsKey(nextString)) {
                    queue.offer(nextString);
                    map.put(nextString, map.get(poppedState) + 1);
                }

                if(!set.contains(prevString) && !map.containsKey(prevString)) {
                    queue.offer(prevString);
                    map.put(prevString, map.get(poppedState) + 1);
                }
            }
        }
        return -1;
    }
}
