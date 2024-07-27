package leetcode.daily_challenge.min_cost_to_convert_string_I;

public class Solution {
    private int MAX_VALUE = Integer.MAX_VALUE;
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] pathDist = new long[26][26];
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < 26; j++) {
                pathDist[i][j] = MAX_VALUE;
                if(i == j) {
                    pathDist[i][j] = 0;
                }
            }
        }
        for(int i = 0; i < original.length; i++) {
            pathDist[original[i] - 'a'][changed[i] - 'a'] = Math.min(cost[i], pathDist[original[i] - 'a'][changed[i] - 'a']);
        }
        // floyd warshall
        for(int k = 0; k < 26; k++) {
            for(int i = 0; i < 26; i++) {
                for(int j = 0; j < 26; j++) {
                    if(pathDist[i][k] + pathDist[k][j] < pathDist[i][j]) {
                        pathDist[i][j] = pathDist[i][k] + pathDist[k][j];
                    }
                }
            }
        }

        long totalCost = 0;
        for(int i = 0; i < source.length(); i++) {
            if(source.charAt(i) == target.charAt(i)) {
                continue;
            }
            if(pathDist[source.charAt(i) - 'a'][target.charAt(i) - 'a'] >= MAX_VALUE) {
                return -1;
            }
            totalCost += pathDist[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
        }
        return totalCost;
    }
}