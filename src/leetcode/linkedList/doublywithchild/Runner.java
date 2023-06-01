package leetcode.linkedList.doublywithchild;

public class Runner {
    public static void main(String[] args) {

         /*
        1--2--3--4--5--6
              |
              7--8
                 |
                 11--12

         */


        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node11 = new Node(11);
        Node node12 = new Node(12);

        //first line
        node1.next = node2;
        node2.prev = node1;

        node2.next = node3;
        node3.prev = node2;

        node3.next = node4;
        node4.prev = node3;

        node4.next = node5;
        node5.prev = node4;

        node5.next = node6;
        node6.prev = node5;

        //second line
        node7.next = node8;
        node8.prev = node7;

        //third line
        node11.next = node12;
        node12.prev = node11;

        //parent child
        node3.child = node7;
        node8.child = node11;

       Node head = node1;
       new Solution().flatten(head);


    }
}
