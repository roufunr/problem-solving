package leetcode.queue_stack.binary_tree_inorder_traversal;

public class Runner {
    public static void main(String[] args) {
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node1 = new TreeNode(1);
//
//        node3.left = node4;
//        node1.left = node2;
//        node1.right = node3;
//
//        new KthLargest().inorderTraversal(node1);

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);

        node7.right = node9;
        node3.left = node7;

        node5.left = node6;

        node2.left = node4;
        node2.right = node5;

        node1.left = node2;
        node1.right = node3;

        new Solution().inorderTraversal(null);
    }
}

//         1
//       /   \
//      2     3
//           /
//          4
