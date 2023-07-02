package leetcode.current.linked_list.remove_nth_from_the_end;

public class Runner {
    public static void main(String[] args) {
        ListNode next = new ListNode(10, null);
        for(int i = 9; i > 0; i--) {
            ListNode temp = new ListNode(i, next);
            next = temp;
        }
        ListNode head = next;
        new Solution().removeNthFromEnd(head, 2);
    }
}
