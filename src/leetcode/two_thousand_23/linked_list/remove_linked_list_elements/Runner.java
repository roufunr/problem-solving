package leetcode.two_thousand_23.linked_list.remove_linked_list_elements;

public class Runner {
    public static void main(String[] args) {
        ListNode next = new ListNode(11);
        for(int i = 10; i > 0; i--) {
            ListNode node = new ListNode((int)(Math.random() * 10), next);
            next = node;
        }
        ListNode head = next;
        new Solution().removeElements(head, 5);
    }
}
