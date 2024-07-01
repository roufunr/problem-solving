package leetcode.extras.redundant_connection;

// dfs got TLE
// this is another approach to solve it
// better approach is to use union find
public class SolutionII {
    private void dfs(int v, int[][] graph, boolean[] visited) {
        int i = 0;
        for (int u : graph[v]) {
            if (u == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, graph, visited);
            }
            i++;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[][] graph = new int[edges.length + 1][edges.length + 1];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        int[] ans = new int[2];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 0;
            graph[edge[1]][edge[0]] = 0;
            boolean[] visited = new boolean[edges.length + 1];
            visited[0] = true;
            visited[edge[0]] = true;
            dfs(edge[0], graph, visited);
            if (visited[edge[1]]) {
                ans[0] = edge[0];
                ans[1] = edge[1];
            }
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        return ans;
    }
}
