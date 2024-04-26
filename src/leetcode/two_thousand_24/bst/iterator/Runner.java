package leetcode.two_thousand_24.bst.iterator;

import leetcode.two_thousand_24.binary_tree.tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3);
        TreeNode node15 = new TreeNode(15);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);

        node15.left = node9;
        node15.right = node20;

        node7.left = node3;
        node7.right = node15;

        BSTIterator bSTIterator = new BSTIterator(node7);
        System.out.println(bSTIterator.next()); // return 3
        System.out.println(bSTIterator.next()); // return 7
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next()); // return 9
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next()); // return 15
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next()); // return 20
        System.out.println(bSTIterator.hasNext()); // return False

    }
}

// BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
