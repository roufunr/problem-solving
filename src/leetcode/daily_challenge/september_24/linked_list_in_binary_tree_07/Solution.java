package leetcode.daily_challenge.september_24.linked_list_in_binary_tree_07;

import java.util.ArrayList;
import java.util.List;

import leetcode.two_thousand_22.linkedList.ListNode;
import leetcode.two_thousand_24.bst.TreeNode;

public class Solution {
    private void getStartNode(TreeNode root, int val, List<TreeNode> startNodes) {
        if(root == null) {
            return;
        }
        if(root.val == val) {
            startNodes.add(root);
        }
        getStartNode(root.left, val, startNodes);
        getStartNode(root.right, val, startNodes);
    }
    private boolean search(TreeNode node, ListNode head) {
        if(head == null && node == null) {
            return true;
        } else if(head == null && node != null) {
            return true;
        } else if(head != null && node == null) {
            return false;
        }
        if(head.val != node.val) {
            return false;
        } else {
            return search(node.left, head.next) || search(node.right, head.next);
        }
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        List<TreeNode> startNodes = new ArrayList<>();
        getStartNode(root, head.val, startNodes);
        for(TreeNode node : startNodes) {
            if(search(node, head)) {
                return true;
            }
        }
        return false;
    }
}