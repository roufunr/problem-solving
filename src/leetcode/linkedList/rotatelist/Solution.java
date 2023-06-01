package leetcode.linkedList.rotatelist;

import javax.swing.text.MaskFormatter;

public class Solution {
    //https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1295/
    public int getLength(ListNode head) {
        ListNode itr = head;
        int len = 0;
        while(itr != null) {
            itr = itr.next;
            len++;
        }
        return len;
    }

    public void makeCircularList(ListNode head) {
        if(head == null) {
            return;
        }
        ListNode itr = head;
        while(itr.next != null) {
            itr = itr.next;
        }
        itr.next = head;
    }

    public int calculateItr(ListNode head, int k) {
        int len = getLength(head);
        if(len == 0 || k == 0) {
            return 0;
        } else {
            k = k % len;
            return len - k;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        int itrCount = calculateItr(head, k);
        if(itrCount == 0) {
            return head;
        }
        makeCircularList(head);
        ListNode prev = head;
        ListNode cur = head.next;
        for(int i = 0; i < itrCount-1; i++) {
            prev = prev.next;
            cur = cur.next;
        }
        head = cur;
        prev.next = null;
        return head;
    }
}
