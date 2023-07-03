package leetcode.two_thousand_23.linked_list.remove_nth_from_the_end;

public class Solution {
    // https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1296/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode itr = head;
        int len = 0;
        while(itr != null) {
            itr = itr.next;
            len++;
        }
        int deletionIdx = len - n;
        if(deletionIdx == 0) {
            if(head != null) {
                head = head.next;
            }
            return head;
        }

        itr = head;
        for(int i = 0; i < deletionIdx - 1; i++) {
            itr = itr.next;
        }

        itr.next = itr.next != null ? itr.next.next : null;
        return head;
    }

    public ListNode removeNthFromEndV2(ListNode head, int n) {
        ListNode itr_first = head;
        ListNode itr_second = head;
        for(int i = 0; i < n; i++) {
            if (itr_second != null) {
                itr_second = itr_second.next;
            }
        }
        if(itr_second == null) {
            head = head == null ? null : head.next;
            return head;
        }

        while(itr_second.next != null) {
            itr_second = itr_second.next;
            itr_first = itr_first.next;
        }
        itr_first.next = itr_first.next != null ? itr_first.next.next : null;
        return head;
    }
}
