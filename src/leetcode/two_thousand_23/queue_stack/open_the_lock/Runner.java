package leetcode.two_thousand_23.queue_stack.open_the_lock;

public class Runner {
    public static void main(String[] args) {
        String[] deadends = {"0000"};
        String target = "8888";
        new Solution().openLock(deadends, target);
    }
}
