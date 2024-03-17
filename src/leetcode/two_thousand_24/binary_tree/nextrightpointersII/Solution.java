package leetcode.two_thousand_24.binary_tree.nextrightpointersII;



import java.util.*;



public class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            Node dummy = new Node(-1);
            while(currentLevelSize > 0) {
                Node levelElement = queue.poll();
                dummy.next = levelElement;
                dummy = dummy.next;
                if(levelElement.left != null) {
                    queue.add(levelElement.left);
                }
                if(levelElement.right != null) {
                    queue.add(levelElement.right);
                }
                currentLevelSize--;
            }
        }
        return root;
    }
}