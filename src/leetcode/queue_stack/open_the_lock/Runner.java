package leetcode.queue_stack.open_the_lock;

public class Runner {
    public static void main(String[] args) {
        String[] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        System.out.println(new Solution().openLock(deadends, target));
    }
}
