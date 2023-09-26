package leetcode.two_thousand_23.queue_stack.keys_and_rooms;

import java.util.*;
public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while(!queue.isEmpty()) {
            Integer front = queue.poll();
            List<Integer> nextRooms = rooms.get(front);
            for(Integer roomIdx : nextRooms) {
                if(visited[roomIdx] == false) {
                    visited[roomIdx] = true;
                    queue.offer(roomIdx);
                }
            }
        }

        for(boolean visitFlag : visited) {
            if(visitFlag == false) {
                return false;
            }
        }
        return true;
    }
}
