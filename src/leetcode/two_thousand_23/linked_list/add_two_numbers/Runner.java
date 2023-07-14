package leetcode.two_thousand_23.linked_list.add_two_numbers;



public class Runner {
    public static void main(String[] args) {
        ListNode next1 = new ListNode(9);
        for(int i = 8; i >= 6; i--) {
            ListNode node = new ListNode(i, next1);
            next1 = node;
        }
        ListNode head1 = next1;

        ListNode next2 = new ListNode(8);
        for(int i = 7; i >= 4; i--) {
            ListNode node = new ListNode(i, next2);
            next2 = node;
        }
        ListNode head2 = next2;
        new Solution().addTwoNumbers(head1, head2);
    }
}
