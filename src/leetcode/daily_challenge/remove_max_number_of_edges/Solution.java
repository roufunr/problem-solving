package leetcode.daily_challenge.remove_max_number_of_edges;

public class Solution {
    private int[][] parent; // 0 -> alice , 1 -> bob
    private int[][] rank;

    private int find(int v, int person) {
        int p = parent[person][v];
        while (p != parent[person][p]) {
            parent[person][p] = parent[person][parent[person][p]];
            p = parent[person][p];
        }
        return p;
    }

    private boolean union(int u, int v, int person) {
        int pu = find(u, person);
        int pv = find(v, person);
        if (pu == pv) {
            return false;
        }
        if (rank[person][pu] > rank[person][pv]) {
            parent[person][pv] = pu;
            rank[person][pu] += rank[person][pv];
        } else {
            parent[person][pu] = pv;
            rank[person][pv] += rank[person][pu];
        }
        return true;
    }

    private boolean checkConnectivity(int n, int person) {
        int p = find(1, person);
        for (int i = 2; i <= n; i++) {
            if (p != find(i, person)) {
                return false;
            }
        }
        return true;
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        parent = new int[2][n + 1];
        rank = new int[2][n + 1];
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < parent[i].length; j++) {
                parent[i][j] = j;
                rank[i][j] = 1;
            }
        }
        int count = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                boolean person0 = union(edge[1], edge[2], 0);
                boolean person1 = union(edge[1], edge[2], 1);

                if (person0 || person1) {
                    count++;
                }
            }
        }
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if ((union(edge[1], edge[2], 0))) {
                    count++;
                }
            } else if (edge[0] == 2){
                if ((union(edge[1], edge[2], 1))) {
                    count++;
                }
            }
        }

        if (checkConnectivity(n, 0) && checkConnectivity(n, 1)) {
            return edges.length - count;
        } else {
            return -1;
        }

    }
}
