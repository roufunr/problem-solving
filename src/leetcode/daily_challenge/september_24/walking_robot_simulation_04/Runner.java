package leetcode.daily_challenge.september_24.walking_robot_simulation_04;

public class Runner {
    public static void main(String[] args) {
        int[] commands = {-2,8,3,7,-1};
        int[][] obstacles = {{-4,-1},{1,-1},{1,4},{5,0},{4,5},{-2,-1},{2,-5},{5,1},{-3,-1},{5,-3}};
        System.out.println(new Solution().robotSim(commands, obstacles));
    }
}
