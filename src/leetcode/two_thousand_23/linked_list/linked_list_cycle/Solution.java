package leetcode.two_thousand_23.linked_list.linked_list_cycle;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    // https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1212/
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null) {
            fast = fast.next != null ? fast.next.next : null;
            slow = slow.next;
            if(fast != null) {
                if(fast == slow) {
                    return true;
                }
            }
        }
        return false;
    }
}
