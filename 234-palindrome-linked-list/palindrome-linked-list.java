/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        Stack<ListNode> stack = new Stack();
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        while(slow.next != null) {
            slow = slow.next;
            stack.add(slow);
        }
        slow = head;
        while(!stack.isEmpty()) {
            if(slow.val != stack.pop().val) return false;
            slow = slow.next;
        }
        return true;
    }
}