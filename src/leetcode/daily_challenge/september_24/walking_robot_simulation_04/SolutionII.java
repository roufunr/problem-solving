package leetcode.daily_challenge.september_24.walking_robot_simulation_04;

import java.util.HashSet;
import java.util.Set;

public class SolutionII {
    private final int CONST = 60001;
    private int getHash(int x, int y) {
        return x + CONST * y;
    }
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Integer> obs = new HashSet<>();
        for(int[] obstacle : obstacles) {
            obs.add(getHash(obstacle[0], obstacle[1]));
        }
        int[] currentPosition = {0, 0};
        int maxDist = 0;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int currentDirection = 0;
        for(int command : commands) {
            if(command == -1) {
                currentDirection = (currentDirection + 1) % 4;
            } else if(command == -2) {
                currentDirection = (currentDirection - 1 + 4) % 4;
            } else {
                int j = 0;
                while(!obs.contains(getHash(currentPosition[0] + dir[currentDirection][0], currentPosition[1] + dir[currentDirection][1]))) {
                    if(j < command) {
                        currentPosition[0] = currentPosition[0] + dir[currentDirection][0];
                        currentPosition[1] = currentPosition[1] + dir[currentDirection][1];
                    } else {
                        break;
                    }
                    maxDist = Math.max(maxDist, currentPosition[0] * currentPosition[0] + currentPosition[1] * currentPosition[1]);
                    j++;
                }
            }
        }
        return maxDist;
    }
}
