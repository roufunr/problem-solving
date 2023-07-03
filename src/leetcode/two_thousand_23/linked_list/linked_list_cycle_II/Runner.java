package leetcode.two_thousand_23.linked_list.linked_list_cycle_II;



public class Runner {
    public static void main(String[] args) {
        ListNode tin = new ListNode(3);
        ListNode dui = new ListNode(2);
        ListNode shunno = new ListNode(0);
        ListNode min_char = new ListNode(-4);

        tin.next = dui;
        dui.next = shunno;
        shunno.next = min_char;
        min_char.next = dui;

        ListNode head = tin;

        new Solution().detectCycle(head);

    }
}
