package leetcode.two_thousand_23.linked_list.odd_even_list;



public class Runner {
    public static void main(String[] args) {
        ListNode next = new ListNode(10);
        for(int i = 9; i > 0; i--) {
            ListNode node = new ListNode(i, next);
            next = node;
        }
        ListNode head = next;
        new Solution().oddEvenList(head);
    }
}
