package leetcode.two_thousand_23.queue_stack.open_the_lock;

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
        if(!set.contains(startState)) {
            queue.offer(startState);
            map.put(startState, 0);
        }
        while (!queue.isEmpty()) {
            String poppedState = queue.poll();
            if(poppedState.equals(target)) {
                return map.get(poppedState);
            }
            char[] poppedStateDigits = poppedState.toCharArray();
            for(int i = 0; i < poppedStateDigits.length; i++) {
                char temp = poppedStateDigits[i];
                char nextDigit = (char)((((poppedStateDigits[i] - '0') + 1)%10) + '0');
                char prevDigit = (char)((((poppedStateDigits[i] - '0') - 1 + 10)%10) + '0');

                poppedStateDigits[i] = nextDigit;
                String nextString = new String(poppedStateDigits);

                poppedStateDigits[i] = prevDigit;
                String prevString = new String(poppedStateDigits);

                if(!set.contains(nextString) && !map.containsKey(nextString)) {
                    queue.offer(nextString);
                    map.put(nextString, map.get(poppedState) + 1);
                }

                if(!set.contains(prevString) && !map.containsKey(prevString)) {
                    queue.offer(prevString);
                    map.put(prevString, map.get(poppedState) + 1);
                }
                poppedStateDigits[i] = temp;
            }
            
        }
        return -1;
    }
}
