package leetcode.two_thousand_23.linked_list.flatten_multilevel_linked_list;

import java.util.Stack;

public class Solution {
    // https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1225/
    public Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
        Node newHead = null;
        Node newItr = null;
        Node itr = head;
        while(itr!=null) {
            Node newNode = new Node();
            newNode.val = itr.val;
            if(newHead == null) {
                newHead = newNode;
                newItr = newHead;
            } else {
                newItr.next = newNode;
                newNode.prev = newItr;
                newItr = newItr.next;
            }

            if(itr.child != null) {
                if(itr.next !=null) stack.push(itr.next);
                itr = itr.child;
            } else if(itr.next != null) {
                itr = itr.next;
            } else if (itr.next == null) {
                itr = stack.isEmpty() ? null : stack.pop();
            }
        }
        return newHead;
    }
}
