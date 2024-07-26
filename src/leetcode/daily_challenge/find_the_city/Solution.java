package leetcode.daily_challenge.find_the_city;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] pathDists = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pathDists[i][j] = distanceThreshold + 1;
                if (i == j) {
                    pathDists[i][j] = 0;
                }
            }
        }

        for (int[] edge : edges) {
            pathDists[edge[0]][edge[1]] = edge[2];
            pathDists[edge[1]][edge[0]] = edge[2];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    pathDists[i][j] = Math.min(pathDists[i][j], pathDists[i][k] + pathDists[k][j]);
                }
            }
        }

        int minCity = -1;
        int minCityCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (pathDists[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= minCityCount) {
                minCityCount = count;
                minCity = i;
            }
        }
        return minCity;
    }
}