package leetcode.two_thousand_23.linked_list.merge_two_linked_list;

public class Solution {
    // https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1227/
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList = null;
        ListNode newListHead = null;
        while(list1 != null || list2 != null) {
            ListNode node = null;
            if(list1 != null && list2 != null) {
                if(list1.val >= list2.val) {
                    node = list2;
                    list2 = list2.next;
                } else {
                    node = list1;
                    list1 = list1.next;
                }
            } else if (list1 != null) {
                node = list1;
                list1 = list1.next;
            } else {
                node = list2;
                list2 = list2.next;
            }
            node.next = null;
            if (newListHead == null) {
                newList = node;
                newListHead = newList;
            } else {
                newList.next = node;
                newList = newList.next;
            }
        }
        return newListHead;
    }
}
