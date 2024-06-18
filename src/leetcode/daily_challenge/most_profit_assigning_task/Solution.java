package leetcode.daily_challenge.most_profit_assigning_task;
import java.util.*;

class Pair {
    public int p;
    public int d;

    public Pair(int p, int d) {
        this.p = p;
        this.d = d;
    }
}

public class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Comparator<Pair> maxComp = new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p2.p, p1.p);
            }
        };
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(maxComp);
        for (int i = 0; i < difficulty.length; i++) {
            Pair pair = new Pair(profit[i], difficulty[i]);
            pq.offer(pair);
        }
        Integer[] w = new Integer[worker.length];
        for (int i = 0; i < w.length; i++) {
            w[i] = worker[i];
        }
        Arrays.sort(w, Collections.reverseOrder());
        int totalProfit = 0;
        int i = 0;
        while (!pq.isEmpty()) {
            Pair top = pq.peek();
            if (top.d <= w[i]) {
                totalProfit += top.p;
                i++;
            } else {
                pq.poll();
            }
            if (i == w.length) {
                break;
            }
        }
        return totalProfit;
    }
}
