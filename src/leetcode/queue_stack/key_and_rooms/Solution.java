package leetcode.queue_stack.key_and_rooms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    //https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1391/
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Boolean> visited = new ArrayList<>();

        for(int i = 0; i < rooms.size(); i++) {
            visited.add(false);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.set(0, true);
        while (!queue.isEmpty()) {
            int currentRoom = queue.remove();
            for(Integer nextRoom : rooms.get(currentRoom)) {
                if(!visited.get(nextRoom)) {
                    visited.set(nextRoom, true);
                    queue.add(nextRoom);
                }
            }
        }

        for(int i = 0; i < visited.size(); i++) {
            if(!visited.get(i)) {
                return false;
            }
        }

        return true;
    }
}
