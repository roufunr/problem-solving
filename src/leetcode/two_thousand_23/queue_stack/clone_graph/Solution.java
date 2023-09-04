package leetcode.two_thousand_23.queue_stack.clone_graph;

import java.util.*;

public class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        Set<String> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        Node newRoot = new Node();
        newRoot.val = node.val;

        Stack<Node> newGraphStack = new Stack<>();
        newGraphStack.push(newRoot);
        Map<Integer, Node> exploredNode = new HashMap();

        exploredNode.put(newRoot.val, newRoot);

        while(!stack.isEmpty()) {
            Node currentNode = stack.pop();
            Node newGCurrentNode = newGraphStack.pop();

            List<Node> adjacencyNodes = currentNode.neighbors;

            for(Node adjNode : adjacencyNodes) {
                String edgeString = (currentNode.val < adjNode.val ? currentNode.val : adjNode.val)
                        + "_"
                        + (currentNode.val > adjNode.val ? currentNode.val : adjNode.val);

                if(!visited.contains(edgeString)) {
                    visited.add(edgeString);
                    stack.push(adjNode);

                    Node newNode = null;
                    if(exploredNode.containsKey(adjNode.val)) {
                        newNode = exploredNode.get(adjNode.val);
                    } else {
                        newNode = new Node(adjNode.val);
                        exploredNode.put(adjNode.val, newNode);
                    }

                    newGCurrentNode.neighbors.add(newNode);
                    newNode.neighbors.add(newGCurrentNode);

                    newGraphStack.push(newNode);
                }
            }
        }

        return newRoot;
    }
}
