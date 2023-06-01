package leetcode.linkedList;

public class Solution {
	
	
	public ListNode removeElements(ListNode head, int val) {
		//https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1207/
        ListNode preHeadNode = new ListNode(999);
        preHeadNode.next = head;
        
        ListNode curNode = head;
        ListNode prevNode = preHeadNode;
        
        while(curNode!=null) {
        	if(curNode.val == val) {
        		prevNode.next = curNode.next;
        	} else {
        		prevNode = prevNode.next;
        	}
        	curNode = curNode.next;
        }
        
        return preHeadNode.next;
    }
	
	public ListNode oddEvenList(ListNode head) {
		//https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1208/
        ListNode evenHead = null;
        ListNode itr = head;
        ListNode evenItr = evenHead;
        int i = 1;
        while(itr != null) {
        	if(itr.next != null) {
        		if(i == 1) {
        			evenHead = itr.next;
        			evenItr = evenHead;
        		} else {
        			evenItr.next = itr.next;
        		}
        		
        		
        		itr.next = itr.next.next;
        		
        		
        		if(i == 1) {
        			evenItr.next = null;
        		} else {
        			evenItr = evenItr.next;
        			evenItr.next = null;
        		}
        		
        		i += 2;
        	}
        	itr = itr.next;
        }
        
        //append 
        itr = head;
        while(itr != null && itr.next != null) {
        	itr = itr.next;
        }
        
        if(itr != null) {
        	itr.next = evenHead;
        }
        
        
		return head;
    }

	public ListNode reverseList(ListNode head) {
		//https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1205/
		if(head==null) {
			return head;
		}
		ListNode blackNode = head;
		ListNode itrNode = head.next;
		while(itrNode != null ) {
			blackNode.next = itrNode.next;
			itrNode.next = head;
			head = itrNode;
			itrNode = blackNode.next;
		}
		return head;
	}
	
	public int getLListLength(ListNode head) {
		ListNode itr = head;
		int counter = 0;
		while(itr != null) {
			itr = itr.next;
			counter++;
		}
		return counter;
	}
	
	public ListNode getNodeByIdx(ListNode head, int idx) {
		ListNode dstNode = null;
		ListNode itr = head;
		for(int i = 0; i <= idx; i++) {
			if(i == idx) {
				dstNode = itr;
			}
			itr = itr.next;
		}
		return dstNode;
	}
	
	public boolean isPalindrome(ListNode head) {
		//https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1209/
		int len = getLListLength(head);
		if(len <= 1) {
			return true;
		}
		
		int secondHalfFirstNodeIdx = len % 2 == 0 ? len/2 : len/2 + 1;
		int firstHalfLastNodeIdx = secondHalfFirstNodeIdx - 1;
		
		ListNode firstHalfLastNode = getNodeByIdx(head, firstHalfLastNodeIdx);
		ListNode secondHalfFirstNode = getNodeByIdx(head, secondHalfFirstNodeIdx);
		
		if(firstHalfLastNode!=null && secondHalfFirstNode!=null) {
			firstHalfLastNode.next = null; // seperate 2 list
			ListNode secondHead = secondHalfFirstNode;
			secondHead = reverseList(secondHead);
			ListNode itr2 = secondHead;
			ListNode itr1 = head;
			boolean isPalindrome = true;
			while(itr2!=null) {
				if(itr2.val != itr1.val) {
					isPalindrome = false;
					break;
				}
				itr2 = itr2.next;
				itr1 = itr1.next;
			}
			
			return isPalindrome;
		} else {
			return true;
		}
        
    }
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		//https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1227/
		list1 = reverseList(list1);
		list2 = reverseList(list2);
		
        ListNode list1HeaderExtension = new ListNode(Integer.MIN_VALUE);
        ListNode list2HeaderExtension = new ListNode(Integer.MIN_VALUE);
        
        list1HeaderExtension.next = list1;
        list2HeaderExtension.next = list2;
        
      
        ListNode mergedSortedList = new ListNode(Integer.MIN_VALUE);
        
        
        while(list1HeaderExtension.next!=null || list2HeaderExtension.next != null) {
        	int list1CurrentHeadItem = list1HeaderExtension.next != null ? list1HeaderExtension.next.val : Integer.MIN_VALUE;
        	int list2CurrentHeadItem = list2HeaderExtension.next != null ? list2HeaderExtension.next.val : Integer.MIN_VALUE;
        	if(list1CurrentHeadItem > Integer.MIN_VALUE && list2CurrentHeadItem > Integer.MIN_VALUE) {
        		//both head exists
        		if(list1CurrentHeadItem > list2CurrentHeadItem) {
        			ListNode curMergedListHeadNode = mergedSortedList.next;
        			ListNode newNode = new ListNode(list1CurrentHeadItem);
        			newNode.next = curMergedListHeadNode;
        			mergedSortedList.next = newNode;
        			
        			list1HeaderExtension.next = list1HeaderExtension.next.next;
        		} else {
        			ListNode curMergedListHeadNode = mergedSortedList.next;
        			ListNode newNode = new ListNode(list2CurrentHeadItem);
        			newNode.next = curMergedListHeadNode;
        			mergedSortedList.next = newNode;
        			
        			list2HeaderExtension.next = list2HeaderExtension.next.next;
        		}
        		
        	} else if(list1CurrentHeadItem > Integer.MIN_VALUE && list2CurrentHeadItem == Integer.MIN_VALUE) {
        		//list1 has remainig item
        		ListNode curMergedListHeadNode = mergedSortedList.next;
    			ListNode newNode = new ListNode(list1CurrentHeadItem);
    			newNode.next = curMergedListHeadNode;
    			mergedSortedList.next = newNode;
    			
    			list1HeaderExtension.next = list1HeaderExtension.next.next;
        		
        	} else if(list1CurrentHeadItem == Integer.MIN_VALUE && list2CurrentHeadItem > Integer.MIN_VALUE) {
        		//list2 has remainig item
        		ListNode curMergedListHeadNode = mergedSortedList.next;
    			ListNode newNode = new ListNode(list2CurrentHeadItem);
    			newNode.next = curMergedListHeadNode;
    			mergedSortedList.next = newNode;
    			
    			list2HeaderExtension.next = list2HeaderExtension.next.next;
        		
        	} else {
        		break;
        	}
        	
        }
        
		ListNode mergedList = mergedSortedList.next;
		//mergedList = reverseList(mergedList);
		return mergedList;
    }

	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1228/
		
        ListNode itr1 = l1;
        ListNode itr2 = l2;
        
        ListNode sumList = null;
        ListNode sumListItr = sumList;
        int carryIn = 0;
        
        while(true) {
        	ListNode newNode = new ListNode();
        	if(itr1 != null && itr2 != null) {
        		int sum = itr1.val + itr2.val + carryIn;
        		int sumD = sum % 10;
        		carryIn = sum / 10;
        		newNode.val = sumD;
        		
        		itr1 = itr1.next;
        		itr2 = itr2.next;
        	} else if(itr1 != null && itr2 == null) {
        		int sum = itr1.val + carryIn;
        		int sumD = sum % 10;
        		carryIn = sum / 10;
        		newNode.val = sumD;
        		
        		itr1 = itr1.next;
        	} else if(itr1 == null && itr2 != null) {
        		int sum = itr2.val + carryIn;
        		int sumD = sum % 10;
        		carryIn = sum / 10;
        		newNode.val = sumD;
        		
        		itr2 = itr2.next;
        	} else {
        		if(carryIn > 0) {
        			newNode.val = carryIn;
        			carryIn = 0;
        		}
        	}
        	
        	if(sumList == null) {
        		sumList = newNode;
        		sumListItr = sumList;
        	} else {
        		sumListItr.next = newNode;
        		sumListItr = sumListItr.next;
        	}
        	
        	if(itr1 == null && itr2 == null && carryIn == 0) break;
        } 
        return sumList;
    }
}
