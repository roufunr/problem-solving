package leetcode.two_thousand_24.binary_tree.nextrightpointersII;

public class Runner {
    public static void main(String[] args) {
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node1 = new Node(1);

        node2.left = node4;
        // node2.right = node5;

        // node3.left = node6;
        node3.right = node7;

        node1.left = node2;
        node1.right = node3;

        new Solution().connect(node1);

    }

}