package leetcode.hash_table.is_happy;

public class Runner {
    public static void main(String[] args) {
        for(int i = 1; i < 1000; i++) {

            if(new Solution().isHappy(i)) {
                System.out.println(i + " -> " + new Solution().isHappy(i));
            }
        }

    }
}
