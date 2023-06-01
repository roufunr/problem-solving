package leetcode.linkedList.sortedcircularlist;

public class Solution {
    //https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1226/
    public Node insert(Node head, int insertVal) {
        if(head == null) {
            Node newNode = new Node(insertVal, null);
            newNode.next = newNode;
            head = newNode;
            return head;
        }

        Node prev = head;
        Node cur = head.next;
        do {

            if(prev.val <= insertVal && cur.val >= insertVal) {
                Node newNode = new Node(insertVal, cur);
                prev.next = newNode;
                return head;
            } else if ((prev.val > cur.val) && (prev.val < insertVal || cur.val > insertVal)){
                Node newNode = new Node(insertVal, cur);
                prev.next = newNode;
                return head;
            } else {
                prev = prev.next;
                cur = cur.next;
            }
        } while(prev != head);

        Node newNode = new Node(insertVal, cur);
        prev.next = newNode;

        return head;
    }
}
