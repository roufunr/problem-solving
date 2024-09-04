package leetcode.daily_challenge.september_24.walking_robot_simulation_04;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obs = new HashSet<>();
        for(int[] obstacle : obstacles) {
            obs.add(obstacle[0] + "_" + obstacle[1]);
        }
        int[] currentPosition = {0, 0};
        int maxDist = 0;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int currentDirection = 0;
        for(int command : commands) {
            if(command == -1) {
                currentDirection =  (currentDirection + 1) % 4;
            } else if(command == -2) {
                currentDirection =  (currentDirection - 1 + 4) % 4;
            } else {
                int j = 0;
                String newPosition = (currentPosition[0] + dir[currentDirection][0]) + "_" + (currentPosition[1] + dir[currentDirection][1]);
                while(!obs.contains(newPosition)) {
                    if(j < command) {
                        currentPosition[0] = currentPosition[0] + dir[currentDirection][0];
                        currentPosition[1] = currentPosition[1] + dir[currentDirection][1];
                    } else {
                        break;
                    }
                    maxDist = Math.max(maxDist, currentPosition[0]* currentPosition[0] + currentPosition[1] * currentPosition[1]);
                    newPosition = (currentPosition[0] + dir[currentDirection][0]) + "_" + (currentPosition[1] + dir[currentDirection][1]);
                    j++;
                }

            }
        }
        return maxDist;
    }
}