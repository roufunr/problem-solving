package leetcode.queue_stack.key_and_rooms;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    //[[1],[2],[3],[]]
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room0 = new ArrayList<>();
        List<Integer> room1 = new ArrayList<>();
        List<Integer> room2 = new ArrayList<>();
        List<Integer> room3 = new ArrayList<>();

        room0.add(1);
        room1.add(2);
        room2.add(3);
        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        System.out.println(new Solution().canVisitAllRooms(rooms));
    }
}
