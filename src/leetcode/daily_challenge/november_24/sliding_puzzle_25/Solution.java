package leetcode.daily_challenge.november_24.sliding_puzzle_25;
import java.util.*;
class Pair {
    public List<List<Integer>> state;
    public int dist;
    public Pair(List<List<Integer>> state, int dist) {
        this.state = state;
        this.dist = dist;
    }
}
public class Solution {
    private int[] getStatePosition(List<List<Integer>> state, int val) {
        int[] position = {-1, -1};
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 3; j++) {
                if(state.get(i).get(j) == val) {
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }
        }
        return position;
    }
    
    public int slidingPuzzle(int[][] board) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<List<List<Integer>>> visited = new HashSet<>();
        List<List<Integer>> finalState = new ArrayList<>();
        finalState.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        finalState.add(new ArrayList<>(Arrays.asList(4, 5, 0)));

        List<List<Integer>> initState = new ArrayList<>();
        for (int[] row : board) {
            List<Integer> rowList = new ArrayList<>();
            for (int element : row) {
                rowList.add(element);
            }
            initState.add(rowList);
        }
        Pair startState = new Pair(initState, 0);
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(startState);
        visited.add(initState);
        while(!queue.isEmpty()) {
            Pair statePair = queue.poll();
            if(statePair.state.equals(finalState)) {
                return statePair.dist;
            }
            int[] othPosition = getStatePosition(statePair.state, 0);
            for(int[] dir : dirs) {
                int newX = othPosition[0] + dir[0];
                int newY = othPosition[1] + dir[1];
                if(newX >= 2 || newX < 0 || newY >= 3 || newY < 0) {
                    continue;
                }
                List<List<Integer>> newState = new ArrayList<>();
                newState.add(new ArrayList<>(statePair.state.get(0)));
                newState.add(new ArrayList<>(statePair.state.get(1)));
                int temp = newState.get(newX).get(newY);
                newState.get(newX).set(newY, statePair.state.get(othPosition[0]).get(othPosition[1]));
                newState.get(othPosition[0]).set(othPosition[1], temp);
                if(!visited.contains(newState)) {
                    Pair newPair = new Pair(newState, statePair.dist + 1);
                    visited.add(newState);
                    queue.offer(newPair);
                }
            }
        }
        return -1;
    }
}