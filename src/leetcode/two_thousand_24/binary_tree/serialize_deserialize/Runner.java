package leetcode.two_thousand_24.binary_tree.serialize_deserialize;

import leetcode.two_thousand_24.binary_tree.tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        // [3,2,4,3]

        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3_ = new TreeNode(3);
        node2.left =node3_;
        node3.left = node2;
        node3.right = node4;

        Codec codec = new Codec();
        String data = codec.serialize(node3);
        codec.deserialize(data);
    }
}
