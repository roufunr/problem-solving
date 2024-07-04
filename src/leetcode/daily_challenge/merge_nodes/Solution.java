package leetcode.daily_challenge.merge_nodes;

import leetcode.two_thousand_23.linked_list.reverse_list.ListNode;

public class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode newListItr = null;
        ListNode newHead = newListItr;
        ListNode itrNode = head;
        while (itrNode != null) {
            if (itrNode.val == 0) {
                itrNode = itrNode.next;
                if (itrNode == null) {
                    break;
                }
                int sum = 0;
                while (itrNode.val != 0) {
                    sum += itrNode.val;
                    itrNode = itrNode.next;
                }
                ListNode newNode = new ListNode(sum);
                if (newHead == null) {
                    newHead = newNode;
                    newListItr = newNode;
                } else {
                    newListItr.next = newNode;
                    newListItr = newListItr.next;
                }
            }

        }
        return newHead;
    }
}
