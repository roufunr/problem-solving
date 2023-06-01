package leetcode.linkedList;

public class Runner {
	public static void main(String[] args) {
		ListNode obj10 = new ListNode(9);
		ListNode obj20 = new ListNode(9);
		ListNode obj30 = new ListNode(9);
		ListNode obj40 = new ListNode(9);
		ListNode obj50 = new ListNode(9);
		
		ListNode obj11 = new ListNode(9);
		ListNode obj21 = new ListNode(9);
		ListNode obj31 = new ListNode(9);
		ListNode obj41 = new ListNode(9);
		ListNode obj51 = new ListNode(9);
		//99999
		//99999
		//199998
		ListNode head1 = obj10;
		obj10.next = obj20;
		obj20.next = obj30;
		obj30.next = obj40;
		obj40.next = obj50;
		
		ListNode head2 = obj11;
		obj11.next = obj21;
		obj21.next = obj31;
		obj31.next = obj41;
		obj41.next = obj51;
		
		new Solution().addTwoNumbers(head1, head2);
		
	}
}
