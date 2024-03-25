package leetcode.two_thousand_24.binary_tree.serialize_deserialize;

import java.util.ArrayList;
import java.util.List;

import leetcode.two_thousand_24.binary_tree.tree.TreeNode;

public class Codec {
    private List<String> res;
    String[] res2;
    private int idx;
    public Codec() {
        res = new ArrayList<>();
        idx = 0;
    }
    
    private void sdfs(TreeNode node) {
        if(node == null) {
            res.add("N");
            return;
        }
        res.add(node.val + "");
        sdfs(node.left);
        sdfs(node.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sdfs(root);
        StringBuilder resultBuilder = new StringBuilder();
        for (String str : res) {
            resultBuilder.append(str).append(",");
        }
        if (resultBuilder.length() > 0) {
            resultBuilder.deleteCharAt(resultBuilder.length() - 1);
        }
        String resultString = resultBuilder.toString();
        return resultString;
    }

    
    private TreeNode ddfs() {
        if(res2[idx].equals("N")) {
            idx++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(res2[idx]));
        idx++;
        node.left = ddfs();
        node.right = ddfs();
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        res2 = data.split(",");
        TreeNode root = ddfs();
        return root;
    }
}
