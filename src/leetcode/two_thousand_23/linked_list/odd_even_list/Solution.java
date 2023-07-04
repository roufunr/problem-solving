package leetcode.two_thousand_23.linked_list.odd_even_list;

public class Solution {
    // https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1208/
    public ListNode oddEvenList(ListNode head) {
            ListNode oddHead = head != null ? head.next : null;
            ListNode even = head;
            ListNode odd = oddHead;
            if(even == null || odd == null) {
                return head;
            }
            while(even != null || odd!= null) {
                if(even != null && even.next != null) {
                    even.next = even.next.next;
                }
                if(odd != null && odd.next != null) {
                    odd.next = odd.next.next;
                }
                even = even !=null ?  even.next : null;
                odd =  odd !=null ?  odd.next : null;
            }
            even = head;
            while(even.next != null) {
                even = even.next;
            }
            even.next = oddHead;
            return head;
    }
}
