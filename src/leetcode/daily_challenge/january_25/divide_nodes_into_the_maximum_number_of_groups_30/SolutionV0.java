package leetcode.daily_challenge.january_25.divide_nodes_into_the_maximum_number_of_groups_30;
import java.util.*;
public class SolutionV0 {
    private List<List<Integer>> adj;
    private List<Integer> getCC(int src, boolean[] explored) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        visited.add(src);
        explored[src] = true;
        while(!queue.isEmpty()) {
            int top = queue.poll();
            for(int nei : adj.get(top)) {
                if(visited.contains(nei) || explored[nei]) {
                    continue;
                }
                queue.add(nei);
                visited.add(nei);
                explored[nei] = true;
            }
        }
        return new ArrayList<>(visited);
    }
    public int magnificentSetsV0(int n, int[][] edges) {
        this.adj = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            this.adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            this.adj.get(edge[0] - 1).add(edge[1] - 1);
            this.adj.get(edge[1] - 1).add(edge[0] - 1);
        }

        List<List<Integer>> ccs = new ArrayList<>();
        boolean[] explored = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!explored[i]) {
                ccs.add(getCC(i, explored));
            }
        }
        int maxGroup = 0;
        for(List<Integer> cc : ccs) {
            
        }
        return 0;
    }
}