package leetcode.linkedList.sortedcircularlist;

public class Runner {
    public static void main(String[] args) {
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        Node node1 = new Node(1, null);

        node3.next = node4;
        node4.next = node1;
        node1.next = node3;


        Node head = node3;
        new Solution().insert(head, 2);
    }
}
