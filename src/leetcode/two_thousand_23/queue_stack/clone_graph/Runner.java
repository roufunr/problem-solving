package leetcode.two_thousand_23.queue_stack.clone_graph;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        // [[2,4],[1,3],[2,4],[1,3]]

        // 1 -> 3, 3
        // 2 -> 4, 4
        // 3 -> 1, 1
        // 4 -> 2, 2

        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();

        node1.val = 1;
        node2.val = 2;
        node3.val = 3;
        node4.val = 4;

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        new Solution().cloneGraph(node1);

    }
}
