package leetcode.daily_challenge.november_24.find_champion_II_26;

public class Solution {
    public int findChampion(int n, int[][] edges) {
        int[][] graph = new int[n][2];

        for(int[] edge : edges) {
            graph[edge[0]][0] += 1;
            graph[edge[1]][1] += 1;
        }

        int ans = -1;
        int count = 0;
        int i = 0;
        for(int[] v : graph) {
            if((v[0] > 0  && v[1] == 0) || (v[0] == 0 && v[1] == 0)) {
                count++;
                ans = i;
            }
            i++;
        }

        return count == 1 ? ans : -1;
    }
}
