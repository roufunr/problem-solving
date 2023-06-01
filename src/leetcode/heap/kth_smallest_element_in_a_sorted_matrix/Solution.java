package leetcode.heap.kth_smallest_element_in_a_sorted_matrix;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
//https://leetcode.com/explore/learn/card/heap/646/practices/4086/ ***
class Triplet implements Comparable<Triplet> {
    public int val;
    public int x;
    public int y;

    public Triplet(int val, int x, int y) {
        this.val = val;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Triplet o) {
        return this.val - o.val;
    }
}
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        Triplet[] triplets = new Triplet[Math.min(n, k)];
        for(int i = 0; i < Math.min(n, k); i++) {
            triplets[i] = new Triplet(matrix[i][0], i, 0);
        }

        PriorityQueue<Triplet> minHeap = new PriorityQueue<>(Arrays.asList(triplets));
        for(int i = 1; i < k; i++) {
            Triplet triplet = minHeap.poll();
            if(triplet.y + 1 < n) {
                minHeap.add(new Triplet(matrix[triplet.x][triplet.y + 1], triplet.x, triplet.y + 1));
            }
        }

        Triplet ans = minHeap.poll();
        return ans.val;
    }
}
