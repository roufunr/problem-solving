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
            while (itrNode != null && currentNode != null) {
                if (currentNode.left == itrNode) {
                    if (currentNode.right != null) {
                        itrNode.next = currentNode.right;
                        itrNode = itrNode.next;
                    } else {
                        currentNode = currentNode.next;
                    }
                } else {
                    currentNode = currentNode.next;
                    if (currentNode == null) {
                        break;
                    }
                    if (currentNode.left != itrNode) {
                        itrNode.next = currentNode.left;
                        itrNode = itrNode.next;
                    }
                }
            }
            currentNode = firstNode;
            Node itrCur = currentNode;
            Node itrCurChild = currentNode.left;
            while (itrCurChild == null) {
                if (itrCur.left == itrCurChild) {
                    itrCurChild = itrCur.right;
                } else {
                    itrCur = itrCur.next;
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