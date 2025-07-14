package leetcode.daily_challenge.july_25.convert_binary_number_in_a_linked_list_to_integer_14;

import leetcode.two_thousand_22.linkedList.ListNode;

public class Solution {
    private int[] calculate(ListNode node) {
        if(node.next == null) {
            return new int[]{1, node.val};
        }
        int[] pair = calculate(node.next);
        return new int[]{pair[0] * 2, pair[0] * 2 * node.val + pair[1]};
    }
    public int getDecimalValue(ListNode head) {
        return calculate(head)[1];
    }
}