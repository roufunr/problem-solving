package leetcode.two_thousand_23.linked_list.rotate_right;

public class Solution {
    //https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1295/
    private int getLen(ListNode head) {
        ListNode itr = head;
        int len = 0;
        while(itr != null) {
            len++;
            itr = itr.next;
        }
        return len;
    }
    public ListNode rotateRight(ListNode head, int k) {
        int len = getLen(head);
        int k_ = len > 0 ?  k % len : 0;
        if(len == 0 || k_ == 0 ) {
            return head;
        }
        ListNode itr = head;
        for(int i = 1; i < (len - k_); i++) {
            itr = itr.next;
        }
        ListNode tail = itr;
        ListNode newHead = itr != null ? itr.next : null;
        tail.next = null;
        itr = newHead;
        while(itr.next != null) {
            itr = itr.next;
        }

        itr.next = head;
        head = newHead;
        return head;
    }
}
