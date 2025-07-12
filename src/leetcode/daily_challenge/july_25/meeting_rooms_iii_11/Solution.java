package leetcode.daily_challenge.july_25.meeting_rooms_iii_11;

import java.util.*;

public class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>((a, b) -> 
            a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        int[] roomUsed = new int[n];
        
        for(int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }
        
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        
        for(int[] meeting : meetings) {
            long startTime = meeting[0];
            long endTime = meeting[1];
            
            // Free all rooms that finished by current start time
            while(!busyRooms.isEmpty() && busyRooms.peek()[0] <= startTime) {
                long[] roomInfo = busyRooms.poll();
                freeRooms.offer((int)roomInfo[1]);
            }
            
            if(!freeRooms.isEmpty()) {
                int roomId = freeRooms.poll();
                roomUsed[roomId]++;
                busyRooms.offer(new long[]{endTime, roomId});
            } else {
                // Wait for earliest finishing room
                long[] roomInfo = busyRooms.poll();
                long newStartTime = roomInfo[0];
                int roomId = (int)roomInfo[1];
                roomUsed[roomId]++;
                busyRooms.offer(new long[]{newStartTime + (endTime - startTime), roomId});
            }
        }
        
        // Find room with most meetings (lowest index if tie)
        int maxIdx = 0;
        int maxCount = roomUsed[0];
        for(int i = 1; i < n; i++) {
            if(roomUsed[i] > maxCount) {
                maxIdx = i;
                maxCount = roomUsed[i];
            }
        }
        return maxIdx;
    }
}