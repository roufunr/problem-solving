package leetcode.two_thousand_24.binary_tree.nextrightpointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class pair {
    public int first;
    public int second;

    public pair(int first, int second) {
        this.first = first;
        this.second = second;

    }
}

public class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }

        Node cur = root;
        Node firstNode = root.left;
        while(firstNode != null) {
            Node nexNode = firstNode;
            while(nexNode != null && cur != null) {
                if(cur.left == nexNode) {
                    nexNode.next = cur.right;
                    cur = cur.next;
                } else {
                    nexNode.next = cur.left;
                }
                nexNode = nexNode.next;
            }
            cur = firstNode;
            firstNode = firstNode.left;
        }
        return root;
    }

    public Node connectv0(Node root) {
        if (root == null) {
            return null;
        }
        Map<Node, pair> depth = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int max_depth = 0;
        depth.put(root, new pair(0, 0));
        while (!queue.isEmpty()) {
            Node top = queue.poll();
            pair m = depth.get(top);
            if (top.left != null) {
                queue.add(top.left);
                depth.put(top.left, new pair(m.first + 1, (m.second * 2) + 0));
            }
            if (top.right != null) {
                queue.add(top.right);
                depth.put(top.right, new pair(m.first + 1, (m.second * 2) + 1));
            }

            if (top.right != null || top.left != null) {
                max_depth++;
            }
        }
        if (max_depth == 0) {
            return root;
        }
        List<List<Node>> levelOrder = new ArrayList<>();

        for (int idx = 0; idx <= max_depth; idx++) {
            List<Node> level = new ArrayList<>();
            int size_of_level = (int) (Math.pow(2, idx));
            for (int j = 0; j < size_of_level; j++) {
                level.add(null);
            }
            levelOrder.add(level);
        }
        for (Map.Entry<Node, pair> entry : depth.entrySet()) {
            Node node = entry.getKey();
            pair p = entry.getValue();
            levelOrder.get(p.first).set(p.second, node);
        }

        for (List<Node> level : levelOrder) {
            for (int i = 0; i < level.size() - 1; i++) {
                if (level.get(i) != null)
                    level.get(i).next = level.get(i + 1);
            }
        }

        return root;
    }

    


}