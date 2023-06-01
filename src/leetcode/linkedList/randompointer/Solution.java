package leetcode.linkedList.randompointer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1229/
    public void makeLinearList(Node head, Node newHead, Map<Node, Node> mapOldToNew, Map<Node, Node> mapNewToOld) {
        if(head == null) {
            return;
        }
        Node itr = head;
        Node itrNew = newHead;
        while(itr!=null) {
            Node newNode = new Node(itr.val);
            itrNew.next = newNode;
            mapNewToOld.put(itrNew.next, itr);
            mapOldToNew.put(itr, itrNew.next);
            itrNew = itrNew.next;

            itr = itr.next;
        }
    }
    public void connectRandomLineage(Node newListHead, Map<Node, Node> mapOldToNew, Map<Node, Node> mapNewToOld) {
        if(mapOldToNew.isEmpty()) {
            return;
        }
        Node itr = newListHead;
        while(itr!=null) {
            Node oldListNode = mapNewToOld.get(itr);
            Node randomNode = oldListNode.random;
            Node randomNodePointerInNewList = mapOldToNew.get(randomNode);
            itr.random = randomNodePointerInNewList;
            itr = itr.next;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> mapOldToNew = new HashMap<>();
        Map<Node, Node> mapNewToOld = new HashMap<>();
        Node newHead = new Node(Integer.MIN_VALUE);
        makeLinearList(head,newHead, mapOldToNew, mapNewToOld);
        connectRandomLineage(newHead.next, mapOldToNew, mapNewToOld);
        return newHead.next;
    }
}
