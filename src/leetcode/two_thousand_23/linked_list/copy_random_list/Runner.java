package leetcode.two_thousand_23.linked_list.copy_random_list;

public class Runner {
    public static void main(String[] args) {
        Node seven = new Node(7);
        Node thirteen = new Node(13);
        Node eleven = new Node(11);
        Node ten = new Node(10);
        Node one = new Node(1);

        seven.next = thirteen;
        seven.random = null;

        thirteen.next = eleven;
        thirteen.random = seven;

        eleven.next = ten;
        eleven.random = one;

        ten.next =  one;
        ten.random = eleven;

        one.next = null;
        one.random = seven;

        Node head = seven;
        new Solution().copyRandomList(head);
    }
}
