package leetcode.extras.redundant_connection;
public class Solution {
    
    private int find(int v, int[] parent, int[] rank) {
        int p = parent[v];
        while(p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    private boolean union(int u, int v, int[] parent, int[] rank) {
        int fu = find(u, parent, rank);
        int fv = find(v, parent, rank);
        if(fu == fv) {
            return false;
        } 

        if(rank[fu] > rank[fv]) {
            parent[fv] = fu;
            rank[fu] += rank[fv];
        } else {
            parent[fu] = fv;
            rank[fv] += rank[fu];
        }
        return true;
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1]; 
        for(int i = 1; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge : edges) {
            if(!union(edge[0], edge[1], parent, rank)) {
                return edge;
            }
        }
        return edges[edges.length - 1]; 
    }
}
