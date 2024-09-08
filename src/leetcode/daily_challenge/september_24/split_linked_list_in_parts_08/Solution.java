package leetcode.daily_challenge.september_24.split_linked_list_in_parts_08;

import leetcode.two_thousand_22.linkedList.ListNode;

public class Solution {
    private int getListSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    private ListNode splitPart(ListNode head, int partSize) {
        for (int i = 1; i < partSize && head != null; i++) {
            head = head.next;
        }
        if (head == null) return null;
        
        ListNode nextPart = head.next;
        head.next = null;
        return nextPart;
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int totalSize = getListSize(head);
        int baseSize = totalSize / k;
        int remainder = totalSize % k;
        ListNode current = head;
        for (int i = 0; i < k; i++) {
            int currentPartSize = baseSize + (remainder > 0 ? 1 : 0);
            remainder--;
            ans[i] = current;
            current = splitPart(current, currentPartSize);
        }
        return ans;
    }
}

