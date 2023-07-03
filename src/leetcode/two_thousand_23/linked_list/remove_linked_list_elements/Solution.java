package leetcode.two_thousand_23.linked_list.remove_linked_list_elements;

public class Solution {
    // https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1207/
    public ListNode removeElements(ListNode head, int val) {
        ListNode itrNode = head;
        if(itrNode == null) {
            return head;
        }
        while(itrNode.next != null) {
            if(itrNode.next.val == val) {
                itrNode.next = itrNode.next.next;
            } else {
                itrNode = itrNode.next;
            }
        }
        if(head.val == val) {
            head = head.next;
        }
        return head;
    }
}
