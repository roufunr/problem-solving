package leetcode.daily_challenge.september_24.delete_nodes_from_linked_list_present_in_array_06;

import java.util.HashSet;
import java.util.Set;

import leetcode.two_thousand_22.linkedList.ListNode;

public class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        if(nums.length == 0 || head == null) {
            return head;
        }
        ListNode itrNode = head;
        while(itrNode.next != null) {
            if(set.contains(itrNode.next.val)) {
                itrNode.next = itrNode.next.next;
                continue;
            } 
            itrNode = itrNode.next;
        }
        if(head != null && set.contains(head.val)) {
            head = head.next;
        }
        return head;
    }
}
