package leetcode.daily_challenge.create_binary_tree;

import java.util.*;
import leetcode.two_thousand_24.bst.TreeNode;

class Child {
    public Integer left;
    public Integer right;
    public Child() {
        this.left = null;
        this.right = null;
    }
}
public class Solution { // accepted and solved with extra class
    private TreeNode create(Integer nodeVal, Map<Integer, Child> map) {
        if(nodeVal == null) {
            return null;
        }
        TreeNode node = new TreeNode();
        node.val = nodeVal;
        if(map.containsKey(nodeVal)) {
            node.left = create(map.get(nodeVal).left, map);
            node.right = create(map.get(nodeVal).right, map);
        }
        return node;
    }
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, Child> map = new HashMap<>();
        Set<Integer> childset = new HashSet<>();
        for(int[] description : descriptions) {
            if(!map.containsKey(description[0])) {
                map.put(description[0], new Child());
            }
            if(description[2] == 1) {
                map.get(description[0]).left = description[1];
            } else {
                map.get(description[0]).right = description[1];
            }
            childset.add(description[1]);
        }
        int rootNode = 0;
        for(Integer key : map.keySet()) {
            if(!childset.contains(key)) {
                rootNode = key;
                break;
            }
        }

        return create(rootNode, map);
    }
}