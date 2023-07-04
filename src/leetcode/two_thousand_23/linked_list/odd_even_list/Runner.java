package leetcode.two_thousand_23.linked_list.odd_even_list;



public class Runner {
    public static void main(String[] args) {
        ListNode next = new ListNode(10);
        for(int i = 1; i > 0; i--) {
            ListNode node = new ListNode(i, next);
            next = node;
        }
        ListNode head = null;
        new Solution().oddEvenList(head);
    }
}
