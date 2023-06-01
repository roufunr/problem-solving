package leetcode.linkedList.rotatelist;

public class Runner {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, null);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = node1;
        new Solution().rotateRight(head, 1);

    }
}
