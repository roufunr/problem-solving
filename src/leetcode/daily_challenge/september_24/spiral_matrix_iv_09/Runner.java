package leetcode.daily_challenge.september_24.spiral_matrix_iv_09;


import leetcode.two_thousand_22.linkedList.ListNode;
import linkedlist.ll;

public class Runner {
    public static void main(String[] args) {
        ll linkedList = new ll();
        int m = 3, n = 5;
        int[] head = {3,0,2,6,8,1,7,9,4,2,5,5,0};
        ListNode listHead = linkedList.constructLinkedList(head);
        new Solution().spiralMatrix(m, n, listHead);
        
    }
}
