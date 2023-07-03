package leetcode.two_thousand_23.linked_list.linked_list_cycle;


public class Runner {
    public static void main(String[] args) {
        // head = [3,2,0,-4], pos = 1
        ListNode three = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode zero = new ListNode(0);
        ListNode minus_four = new ListNode(-4);

        three.next = two;
        two.next = zero;
        zero.next = minus_four;
        minus_four.next = two;

        ListNode head = three;

        new Solution().hasCycle(head);
    }
}
