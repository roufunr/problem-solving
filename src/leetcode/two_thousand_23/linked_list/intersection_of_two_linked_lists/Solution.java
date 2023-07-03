package leetcode.two_thousand_23.linked_list.intersection_of_two_linked_lists;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1215/
    public ListNode getIntersectionNodeV1(ListNode headA, ListNode headB) {
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


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode itrA = headA;
        while(itrA != null) {
            itrA.val *= (-1);
            itrA = itrA.next;
        }
        ListNode intersection = null;
        ListNode itrB = headB;
        while(itrB != null) {
            if(itrB.val < 0) {
                intersection = itrB;
                break;
            }
            itrB = itrB.next;
        }
        itrA = headA;
        while(itrA != null) {
            itrA.val *= (-1);
            itrA = itrA.next;
        }
        return intersection;
    }
}
