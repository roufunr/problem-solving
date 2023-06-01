package leetcode.linkedList.doublywithchild;

import java.util.*;

public class Solution {
    //https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1225/
    public Node flatten(Node head) {
        Node itr = head;
        flattenTheList(itr, new Stack<>());
        return head;
    }

    public Node flattenTheList(Node node, Stack<Node> stack) {
        if(node==null) {
            return null;
        }
        else if(node.child != null) {
            if(node.next!=null) stack.push(node.next);

            node.next = node.child;
            node.child.prev = node;
            node.child = null;

            flattenTheList(node.next, stack);

        } else if(node.next != null) {
            flattenTheList(node.next, stack);

        } else if(node.next == null && stack.size() > 0) {
            Node nodeFromParentList = (Node) stack.pop();
            node.next = nodeFromParentList;
            nodeFromParentList.prev = node;
            flattenTheList(node.next, stack);
        } else {
            return null;
        }
        return null;
    }
}
