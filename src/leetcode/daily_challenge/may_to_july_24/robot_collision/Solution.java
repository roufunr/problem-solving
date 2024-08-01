package leetcode.daily_challenge.may_to_july_24.robot_collision;

import java.util.*;

class Robot {
    public int position;
    public int healthIdx;
    public char direction;

    public Robot(int position, int healthIdx, char direction) {
        this.position = position;
        this.healthIdx = healthIdx;
        this.direction = direction;
    }
}

public class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Robot> robots = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            robots.add(new Robot(positions[i], i, directions.charAt(i)));
        }

        Comparator<Robot> comp = new Comparator<Robot>() {
            @Override
            public int compare(Robot r1, Robot r2) {
                return Integer.compare(r1.position, r2.position);
            }
        };

        Collections.sort(robots, comp);
        Stack<Robot> stack = new Stack<>();
        for (int i = 0; i < positions.length; i++) {
            Robot robot = robots.get(i);
            if (robot.direction == 'R') {
                stack.push(robot);
            } else {
                while (!stack.isEmpty() && healths[robot.healthIdx] > 0) {
                    if (healths[robot.healthIdx] > healths[stack.peek().healthIdx]) {
                        healths[stack.peek().healthIdx] = 0;
                        healths[robot.healthIdx] -= 1;
                        stack.pop();
                    } else if (healths[robot.healthIdx] < healths[stack.peek().healthIdx]) {
                        healths[stack.peek().healthIdx] -= 1;
                        healths[robot.healthIdx] = 0;
                    } else {
                        healths[stack.peek().healthIdx] = 0;
                        healths[robot.healthIdx] = 0;
                        stack.pop();
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int health : healths) {
            if (health > 0) {
                ans.add(health);
            }
        }

        return ans;
    }
}