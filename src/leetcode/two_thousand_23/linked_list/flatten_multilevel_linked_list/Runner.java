package leetcode.two_thousand_23.linked_list.flatten_multilevel_linked_list;

public class Runner {
    public static void main(String[] args) {
        Node one  = new Node();
        one.val = 1;
        Node two = new Node();
        two.val = 2;
        Node three = new Node();
        three.val = 3;
        Node four = new Node();
        four.val = 4;
        Node five = new Node();
        five.val = 5;
        Node six = new Node();
        six.val = 6;
        Node  seven = new Node();
        seven.val = 7;
        Node eight = new Node();
        eight.val = 8;
        Node nine = new Node();
        nine.val = 9;
        Node ten = new Node();
        ten.val = 10;
        Node eleven = new Node();
        eleven.val = 11;
        Node twelve = new Node();
        twelve.val = 12;

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        seven.next = eight;
        eight.next = null;
        nine.next = ten;

        eleven.next = twelve;

        three.child = seven;
        eight.child = eleven;

        Node head = one;

        new Solution().flatten(head);


    }
}
