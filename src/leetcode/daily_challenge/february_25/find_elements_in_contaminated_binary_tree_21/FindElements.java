package leetcode.daily_challenge.february_25.find_elements_in_contaminated_binary_tree_21;

import java.util.LinkedList;
import java.util.Queue;
import leetcode.two_thousand_24.bst.TreeNode;

public class FindElements {
    private TreeNode root;
    public FindElements(TreeNode root) {
        if(root != null && root.val == -1) {
            root.val = 0;
            fixTree(root);
        }
        this.root = root;
    }
    private void fixTree(TreeNode node) {
        if(node ==  null) {
            return;
        }
        if(node.left != null) {
            if(node.left.val == -1){ 
                node.left.val = node.val * 2 + 1;
            }
        }
        if(node.right != null) {
            if(node.right.val == -1){ 
                node.right.val = node.val * 2 + 1;
            }
        }
        fixTree(node.left);
        fixTree(node.right);
    }
    
    public boolean find(int target) {
        if(this.root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this.root);
        while(!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if(top.val == target) {
                return true;
            } else if(top.val > target) {
                break;
            }
            if(top.left != null) {
                queue.offer(top.left);
            } 
            if(top.right != null) {
                queue.offer(top.right);
            }
        }
        return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */