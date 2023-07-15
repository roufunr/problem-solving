package leetcode.two_thousand_23.linked_list.copy_random_list;

public class Solution {
    // https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1229/
    public Node copyRandomList(Node head) {
        Node newHead = null;
        Node newItr = null;
        Node itr = head;
        while(itr != null) {
            Node newNode = new Node(itr.val);
            if(newHead == null) {
                newHead = itr;
                itr = itr.next;
                newHead.next = newNode;
                newItr = newNode;
            } else {
                newItr.next = itr;
                itr = itr.next;
                newItr = newItr.next;
                newItr.next = newNode;
                newItr = newItr.next;
            }
        }
        // fix random pointer
        itr = newHead;
        while(itr != null) {
            itr.next.random = itr.random == null ? null : itr.random.next;
            itr = itr.next.next;
        }

        head = newHead;
        itr = newHead;

        newHead = head == null ? null : head.next;
        newItr = newHead;

        while(itr != null) {
            itr.next = itr.next != null ? itr.next.next : null;
            newItr.next = newItr.next != null ? newItr.next.next : null;

            itr = itr.next ;
            newItr = newItr.next;
        }


        return newHead;
    }
}
