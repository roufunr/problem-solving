package leetcode.two_thousand_23.linked_list.remove_nth_from_the_end;

public class Runner {
    public static void main(String[] args) {
        ListNode next = new ListNode(3, null);
        for(int i = 2; i > 0; i--) {
            ListNode temp = new ListNode(i, next);
            next = temp;
        }
        ListNode head = next;
        new Solution().removeNthFromEndV2(head, 3);
    }
}
