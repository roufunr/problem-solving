package leetcode.two_thousand_23.linked_list.merge_two_linked_list;

public class Runner {
    public static void main(String[] args) {
        ListNode next1 = new ListNode(5);
        for(int i = 4; i >= 1; i--) {
            ListNode node1 = new ListNode(i, next1);
            next1 = node1;
        }
        ListNode head1 = next1;

        ListNode next2 = new ListNode(10);
        for(int i = 9; i >= 6; i--) {
            ListNode node2 = new ListNode(i, next2);
            next2 = node2;
        }
        ListNode head2 = next2;

        new Solution().mergeTwoLists(head1, head2);
    }
}
