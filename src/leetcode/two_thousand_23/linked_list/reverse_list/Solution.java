package leetcode.two_thousand_23.linked_list.reverse_list;

public class Solution {
    // https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1205/
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head != null) {
            ListNode topNode = head;
            head = head.next;
            topNode.next = newHead;
            newHead = topNode;
        }
        head = newHead;
        return head;
    }
}
