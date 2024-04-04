package leetcode.two_thousand_24.recursion.merge_two_sorted_list;


class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { 
        this.val = val; 
    }
    public ListNode(int val, ListNode next) { 
        this.val = val; this.next = next; 
    }
}
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) {
            return list1;
        } else if(list1 == null) {
            return list2;
        } else if(list2 == null) {
            return list1;
        }

        ListNode list1Settled = list1;
        ListNode list2Next = list2.next;
        if(list2.val < list1Settled.val) {
            list2.next = list1;
            list1Settled = list2;
            list2 = list2Next;
        }
        list1Settled.next = mergeTwoLists(list1Settled.next, list2);
        return list1Settled;
    }
}