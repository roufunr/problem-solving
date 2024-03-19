package leetcode.two_thousand_24.binary_tree.nextrightpointersII;

public class Runner {
    public static void main(String[] args) {
        Node node3 = new Node(3);
        Node node9 = new Node(9);
        Node node20 = new Node(20);
        Node node15 = new Node(15);
        Node node7 = new Node(7);

        node20.left = node15;
        node20.right = node7;

        node3.left = node9;
        node3.right = node20;
        new Solution().connect(node3);

    }

}