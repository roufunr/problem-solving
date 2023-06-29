package leetcode.current.linked_list.linked_list_cycle;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
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
