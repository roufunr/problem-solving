package leetcode.daily_challenge.july_25.meeting_rooms_iii_11;

public class Runner {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int[][] meetings =  {{18, 19}, {3, 12}, {17, 19}, {2, 13}, {7, 10}};

        int result = solution.mostBooked(n, meetings);
        System.out.println("The room that was booked the most is: " + result);
    }
}
