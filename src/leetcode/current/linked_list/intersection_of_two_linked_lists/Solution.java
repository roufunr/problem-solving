package leetcode.current.linked_list.intersection_of_two_linked_lists;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while(headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while(headB != null) {
            if(set.contains(headB)) {
                return headB;
            } else {
                headB = headB.next;
            }
        }
        return null;
    }
}
