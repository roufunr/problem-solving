package leetcode.queue_stack.clone_graph;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public void clone(Node src, Node dst, HashSet<String> edgeSet, HashMap<Integer, Node> createdNodes) {
        for (Node adj : src.neighbors) {
            String edge_from_to = src.val + "_" + adj.val;
            String edge_to_from = adj.val + "_" + src.val;
            if(edgeSet.contains(edge_from_to)) {
                continue;
            } else {
                edgeSet.add(edge_from_to);
                edgeSet.add(edge_to_from);
                if(createdNodes.containsKey(adj.val)) {
                    Node createdNode = createdNodes.get(adj.val);
                    createdNode.neighbors.add(dst);
                    dst.neighbors.add(createdNode);
                } else {
                    Node newNode = new Node(adj.val);
                    newNode.neighbors.add(dst);
                    dst.neighbors.add(newNode);
                    createdNodes.put(adj.val, newNode);
                    clone(adj, newNode, edgeSet, createdNodes);
                }
            }
        }
    }
    public Node cloneGraph(Node node) {
        Node oldRoot = node;
        if(oldRoot == null) {
            return null;
        }
        Node newRoot = new Node(oldRoot.val);
        HashSet<String> edgeSet = new HashSet<>(); // edge -> node1.val_node2
        HashMap<Integer, Node> createdNodes = new HashMap<>();
        createdNodes.put(oldRoot.val, newRoot);
        clone(oldRoot, newRoot, edgeSet, createdNodes);
        return newRoot;
    }
}
