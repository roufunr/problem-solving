package leetcode.current.beginners_guide.middle_of_the_linked_list;

public class Solution {
    //https://leetcode.com/problems/middle-of-the-linked-list/
    private int linkedListLength(ListNode head) {
        int l = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            l++;
        }
        return l;
    }
    public ListNode middleNode(ListNode head) {
        int len = linkedListLength(head);
        int midIdx = (int) Math.floor(len / 2.0);
        ListNode temp = head;
        int i = 0;
        while(i < midIdx) {
            temp = temp.next;
            i++;
        }
        return temp;
    }
}
