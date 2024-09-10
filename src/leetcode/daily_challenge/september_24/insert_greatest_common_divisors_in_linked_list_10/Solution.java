package leetcode.daily_challenge.september_24.insert_greatest_common_divisors_in_linked_list_10;

import leetcode.two_thousand_22.linkedList.ListNode;

public class Solution {
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode itrNode = head;
        while (itrNode != null && itrNode.next != null) {
            int g = gcd(itrNode.val, itrNode.next.val);
            ListNode newNode = new ListNode(g);
            newNode.next = itrNode.next;
            itrNode.next = newNode;
            itrNode = itrNode.next.next;
        }
        return head;
    }
}