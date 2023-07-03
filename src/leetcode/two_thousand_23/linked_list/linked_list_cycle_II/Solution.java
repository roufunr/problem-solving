package leetcode.two_thousand_23.linked_list.linked_list_cycle_II;

public class Solution {
    // https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1214/
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode actual = null;
        while(fast != null) {
            fast = fast.next != null ? fast.next.next : null;
            slow = slow.next;
            if (fast == slow && fast != null) {
                actual = head;
                while(true) {
                    if(actual == slow) {
                        return actual;
                    }
                    actual = actual.next;
                    slow = slow.next;
                }
            }
        }
        return null;
    }
}
