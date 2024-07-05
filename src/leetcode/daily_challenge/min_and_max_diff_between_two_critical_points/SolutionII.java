package leetcode.daily_challenge.min_and_max_diff_between_two_critical_points;

import leetcode.two_thousand_22.linkedList.ListNode;

public class SolutionII {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // better solution in terms of memory and runtime
        ListNode itrNode = head;
        int i = 1;
        int prevIdx = -1;
        int firstIdx = -1;
        int minDiff = Integer.MAX_VALUE;
        while (itrNode.next.next != null) {
            ListNode before = itrNode;
            ListNode current = itrNode.next;
            ListNode after = itrNode.next.next;
            if (before.val < current.val && current.val > after.val) {
                if (firstIdx == -1) {
                    firstIdx = i;
                }
                if (prevIdx != -1) {
                    minDiff = minDiff > i - prevIdx ? i - prevIdx : minDiff;
                }
                prevIdx = i;
            }

            if (before.val > current.val && current.val < after.val) {
                if (firstIdx == -1) {
                    firstIdx = i;
                }
                if (prevIdx != -1) {
                    minDiff = minDiff > i - prevIdx ? i - prevIdx : minDiff;
                }
                prevIdx = i;
            }
            i++;
            itrNode = itrNode.next;
        }
        if (prevIdx == -1 || prevIdx == firstIdx) {
            return new int[] { -1, -1 };
        }

        return new int[] { minDiff, prevIdx - firstIdx };
    }
}
