package leetcode.linkedList;

//https://leetcode.com/explore/learn/card/linked-list/209/singly-linked-list/1290/
public class MyLinkedList {
	private SinglyListNode head;
	
    public MyLinkedList() {
    	head = null;
    }
    
    public int get(int index) {
    	int listLen = this.getListLength();
        if(index >= listLen || index < 0) {
        	return -1;
        }
        
        SinglyListNode traverser = head;
        int i = 0;
        while(i < index) {
        	traverser = traverser.next;
        	i++;
        }
        
        return traverser.val;
    }
    
    public void addAtHead(int val) {
        SinglyListNode node = new SinglyListNode(val);
        node.next = head;
        head = node;
    }
    
    public void addAtTail(int val) {
    	SinglyListNode tailNode = new SinglyListNode(val);
    	tailNode.next = null;
    	
    	if(head == null) {
    		this.addAtHead(val);
    		return;
    	}
    	
    	SinglyListNode traverser = head;
    	while(traverser.next != null) {
    		traverser = traverser.next;
    	}
    	
    	traverser.next = tailNode;
    }
    
    public void addAtIndex(int index, int val) {
        int listLen = this.getListLength();
        if(index > listLen) {
        	return;
        }
        
        if(index == 0) {
        	 SinglyListNode newNode = new SinglyListNode(val);
        	 newNode.next = head;
        	 head = newNode;
        	 return;
        }
        
        SinglyListNode traverser = head;
        int i = 0;
        while(i < index-1) {
        	traverser = traverser.next;
        	i++;
        }
        
        SinglyListNode prevNode = traverser;
        SinglyListNode nextNode = traverser.next;
        
        SinglyListNode newNode = new SinglyListNode(val);
        prevNode.next = newNode;
        newNode.next = nextNode;
    }
    
    public void deleteAtIndex(int index) {
    	int listLen = this.getListLength();
        if(index >= listLen) {
        	return;
        }
        if(index == 0) {
        	head = head.next;
        	return;
        }
        
        SinglyListNode traverser = head;
        int i = 0;
        while(i < index-1) {
        	traverser = traverser.next;
        	i++;
        }
        SinglyListNode prevNode = traverser;
        SinglyListNode nextNode = traverser.next == null ? null : traverser.next.next;
        
        prevNode.next = nextNode;
    }
    
    public int getListLength() {
    	int i = 0;
    	SinglyListNode traverser = head;
    	while(traverser!=null) {
    		traverser = traverser.next;
    		i++;
    	}
    	return i;
    }
    
    public void printList() {
    	SinglyListNode traverser = head;
    	String str = "[";
    	while(traverser != null) {
    		int val = traverser.val;
    		str += val;
    		str += traverser.next == null ? "" : ", ";
    		traverser = traverser.next;
    	}
    	str+="]";
    	System.out.println(str);
    }
}
