package leetcode.daily_challenge.march_25.minimum_time_to_repair_cars_16;

public class Solution {

    public long repairCars(int[] ranks, int cars) {
        // Count the frequency of each rank
        Map<Integer, Integer> count = new HashMap<>();
        for (int rank : ranks) {
            count.put(rank, count.getOrDefault(rank, 0) + 1);
        }

        
        PriorityQueue<long[]> minHeap = new PriorityQueue<>((a, b) ->
            Long.compare(a[0], b[0])
        );

        
        for (int rank : count.keySet()) {
            // Elements: [time, rank, cars_repaired, mechanic_count]
            minHeap.offer(new long[] { rank, rank, 1, count.get(rank) });
        }

        long time = 0;
        
        while (cars > 0) {
            
            long[] current = minHeap.poll();
            time = current[0];
            int rank = (int) current[1];
            long n = current[2];
            int mechCount = (int) current[3];

            
            cars -= mechCount;

            
            n += 1;

            
            minHeap.offer(new long[] { rank * n * n, rank, n, mechCount });
        }

        return time;
    }
}