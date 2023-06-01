package leetcode.heap.the_K_weakest_rows_in_a_matrix;

import java.util.PriorityQueue;
//https://leetcode.com/explore/learn/card/heap/646/practices/4085/
class Pair implements Comparable<Pair> {
    // this comes first for ascending sort
    public int idx;
    public int count;

    public Pair(int idx, int count) {
        this.idx = idx;
        this.count = count;
    }

    @Override
    public int compareTo(Pair o) {
        if(o.count != this.count) {
            return this.count - o.count;
        } else {
            return this.idx - o.idx;
        }
    }
}
public class Solution {
    int oneCount(int[] row) {
        int count = 0;
        for(int i = 0; i < row.length; i++) {
            if(row[i] == 0) {
                return count;
            } else {
                count++;
            }
        }
        return count;
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        for(int i = 0; i < mat.length; i++) {
            minHeap.add(new Pair(i, oneCount(mat[i])));
        }

        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = minHeap.poll().idx;
        }
        return ans;
    }
}
