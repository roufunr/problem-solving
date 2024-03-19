package leetcode.two_thousand_24.binary_tree.nextrightpointersII;

import java.util.*;

public class Solution {
    public Node connectV1(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            Node dummy = new Node(-1);
            while (currentLevelSize > 0) {
                Node levelElement = queue.poll();
                dummy.next = levelElement;
                dummy = dummy.next;
                if (levelElement.left != null) {
                    queue.add(levelElement.left);
                }
                if (levelElement.right != null) {
                    queue.add(levelElement.right);
                }
                currentLevelSize--;
            }
        }
        return root;
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node currentNode = root;
        Node firstNode = currentNode.left != null ? currentNode.left : currentNode.right;
        while (firstNode != null) {
            Node itrNode = firstNode;
            while (currentNode != null) {
                if(currentNode.left == null && currentNode.right == null) {
                    currentNode = currentNode.next;
                } else {
                    if(currentNode.left != null) {
                        if(currentNode.left == itrNode) {
                            if(currentNode.right != null) {
                                itrNode.next = currentNode.right;
                                itrNode= itrNode.next;
                            }
                            currentNode = currentNode.next;
                        } else {
                            itrNode.next = currentNode.left;
                            itrNode = itrNode.next;
                        }
                    } else { // right not null
                        if(currentNode.right != itrNode) {
                            itrNode.next = currentNode.right;
                            itrNode =  itrNode.next;
                        }
                        currentNode = currentNode.next;
                    }
                }
            }
            currentNode = firstNode;
            Node itrCur = currentNode;
            Node itrCurChild = null;
            while (itrCur != null) {
                if(itrCur.left == null && itrCur.right == null) {
                    itrCur = itrCur.next;
                } else {
                    if(itrCur.left != null) {
                        itrCurChild = itrCur.left;
                        break;
                    } else {
                        itrCurChild = itrCur.right;
                        break;
                    }
                }
            }
            if (itrCur == null) {
                break;
            }
            firstNode = itrCurChild;
        }

        return root;
    }
}