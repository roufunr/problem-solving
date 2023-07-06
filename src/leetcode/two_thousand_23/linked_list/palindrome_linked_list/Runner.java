package leetcode.two_thousand_23.linked_list.palindrome_linked_list;

public class Runner {
    public static void main(String[] args) {
        int[] arr = {};
        ListNode next = arr.length >= 1 ? new ListNode(arr[arr.length - 1]) : null;
        for(int i = arr.length - 2; i >=0 ; i--) {
            ListNode node = new ListNode(arr[i], next);
            next = node;
        }
        ListNode head = next;
        System.out.println(new Solution().isPalindrome(head));;
    }
}
