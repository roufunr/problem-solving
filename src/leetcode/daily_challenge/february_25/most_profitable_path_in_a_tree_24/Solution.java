package leetcode.daily_challenge.february_25.most_profitable_path_in_a_tree_24;

public import java.util.*;

class Solution {
    private Map<Integer, Integer> bobPath;
    private boolean[] visited;
    private List<List<Integer>> tree;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        int maxIncome = Integer.MIN_VALUE;
        tree = new ArrayList<>();
        bobPath = new HashMap<>();
        visited = new boolean[n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});

        for (int i = 0; i < n; i++) tree.add(new ArrayList<>());
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        findBobPath(bob, 0);
        Arrays.fill(visited, false);

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int source = node[0], time = node[1], income = node[2];

            if (!bobPath.containsKey(source) || time < bobPath.get(source)) {
                income += amount[source];
            } else if (time == bobPath.get(source)) {
                income += amount[source] / 2;
            }

            if (tree.get(source).size() == 1 && source != 0) {
                maxIncome = Math.max(maxIncome, income);
            }
            
            for (int adj : tree.get(source)) {
                if (!visited[adj]) {
                    queue.add(new int[]{adj, time + 1, income});
                }
            }
            visited[source] = true;
        }
        return maxIncome;
    }

    private boolean findBobPath(int node, int time) {
        bobPath.put(node, time);
        visited[node] = true;
        if (node == 0) return true;
        
        for (int adj : tree.get(node)) {
            if (!visited[adj] && findBobPath(adj, time + 1)) return true;
        }
        
        bobPath.remove(node);
        return false;
    }
}
