package leetcode.two_thousand_23.linked_list.rotate_right;



public class Runner {
    public static void main(String[] args) {
        ListNode next = new ListNode(5);
        for(int i = 4; i >= 0; i--) {
            ListNode node = new ListNode(i, next);
            next = node;
        }
        ListNode head = next;
        new Solution().rotateRight(head, 6);


    }
}
