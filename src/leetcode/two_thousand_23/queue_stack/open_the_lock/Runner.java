package leetcode.two_thousand_23.queue_stack.open_the_lock;

public class Runner {
    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        new Solution().openLock(deadends, target);
    }
}
