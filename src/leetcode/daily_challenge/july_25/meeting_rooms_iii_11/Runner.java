package leetcode.daily_challenge.july_25.meeting_rooms_iii_11;

public class Runner {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int[][] meetings =  {{19,20},{14,15},{13,14},{11,20}};
        int result = solution.mostBooked(n, meetings);
        System.out.println("The room that was booked the most is: " + result);
    }
}
