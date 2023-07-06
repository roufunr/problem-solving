package leetcode.two_thousand_23.linked_list.palindrome_linked_list;

import java.util.Stack;

public class Solution {
    // https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1209/
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode itr = head;
        while(itr!=null) {
            stack.push(itr.val);
            itr = itr.next;
        }
        itr = head;
        int n = stack.size();
        for(int i = 0; i <= (n/2); i++) {
            if(itr==null || itr.val != stack.peek()) {
                return false;
            }
            stack.pop();
            itr = itr.next;
        }
        return true;
    }
}
