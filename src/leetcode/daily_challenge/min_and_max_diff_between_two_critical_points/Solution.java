package leetcode.daily_challenge.min_and_max_diff_between_two_critical_points;

import java.util.*;

import leetcode.two_thousand_22.linkedList.ListNode;

public class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode itrNode = head;
        int i = 1;
        List<Integer> criticalIdx = new ArrayList<>();
        while (itrNode.next.next != null) {
            ListNode before = itrNode;
            ListNode current = itrNode.next;
            ListNode after = itrNode.next.next;
            if (before.val < current.val && current.val > after.val) {
                criticalIdx.add(i);
            }

            if (before.val > current.val && current.val < after.val) {
                criticalIdx.add(i);
            }
            i++;
            itrNode = itrNode.next;
        }
        if (criticalIdx.size() < 2) {
            return new int[] { -1, -1 };
        }
        int maxDiff = criticalIdx.get(criticalIdx.size() - 1) - criticalIdx.get(0);
        int minDiff = Integer.MAX_VALUE;
        for (i = 1; i < criticalIdx.size(); i++) {
            minDiff = minDiff > (criticalIdx.get(i) - criticalIdx.get(i - 1))
                    ? (criticalIdx.get(i) - criticalIdx.get(i - 1))
                    : minDiff;
        }
        return new int[] { minDiff, maxDiff };
    }
}