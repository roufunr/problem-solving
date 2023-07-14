package leetcode.two_thousand_23.linked_list.add_two_numbers;
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode itr1 = l1;
        ListNode itr2 = l2;
        ListNode itr = null;
        ListNode head = null;
        int remainder = 0;
        while(itr1 != null || itr2 != null) {
            int num1 = itr1 != null ? itr1.val : 0;
            int num2 = itr2 != null ? itr2.val : 0;
            int digit = num1 + num2 + remainder;
            remainder = digit / 10;
            digit = digit % 10;
            ListNode newNode = new ListNode(digit);
            if(head == null) {
                head = newNode;
                itr = head;
            } else {
                itr.next = newNode;
                itr = itr.next;
            }
            itr1 = itr1 != null ? itr1.next : null;
            itr2 = itr2 != null ? itr2.next : null;
        }
        if(remainder > 0) {
            ListNode newNode = new ListNode(remainder);
            itr.next = newNode;
            itr = itr.next;
        }
        return head;
    }
}
