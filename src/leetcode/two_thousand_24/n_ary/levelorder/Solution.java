package leetcode.two_thousand_24.n_ary.levelorder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import leetcode.two_thousand_24.n_ary.Node;

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelData = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                levelData.add(queue.peek().val);
                for (Node n : queue.peek().children) {
                    queue.add(n);
                }
                queue.poll();
            }
        }

        return ans;
    }
}