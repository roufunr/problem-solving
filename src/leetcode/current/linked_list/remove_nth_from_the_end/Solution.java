package leetcode.current.linked_list.remove_nth_from_the_end;

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
}
