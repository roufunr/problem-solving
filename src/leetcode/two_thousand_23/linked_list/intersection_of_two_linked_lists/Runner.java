package leetcode.two_thousand_23.linked_list.intersection_of_two_linked_lists;

public class Runner {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;

        four.next = five;
        five.next = two;

        ListNode headA = one;
        ListNode headB = four;

        new Solution().getIntersectionNode(headA, headB);
    }
}
