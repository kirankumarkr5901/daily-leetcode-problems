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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack();
        Stack<ListNode> s2 = new Stack();

        ListNode iter = l1;
        while(iter != null) {
            s1.add(iter);
            iter = iter.next;
        }

        iter = l2;
        while(iter != null) {
            s2.add(iter);
            iter = iter.next;
        }

        boolean isCarry = false;
        ListNode prev = null;
        ListNode curr = null;

        while(!s1.isEmpty() && !s2.isEmpty()) {
            int sum = s1.pop().val + s2.pop().val;
            if(isCarry) sum++;
            if(sum > 9) {
                isCarry = true;
                sum %= 10;
            } else {
                isCarry = false;
            }

            ListNode newNode = new ListNode(sum);
            curr = newNode;
            curr.next = prev;
            prev = curr;
        }

        while(!s1.isEmpty()) {
            int sum = s1.pop().val;
            if(isCarry) sum++;
            if(sum > 9) {
                isCarry = true;
                sum %= 10;
            } else {
                isCarry = false;
            }

            ListNode newNode = new ListNode(sum);
            curr = newNode;
            curr.next = prev;
            prev = curr;
        }

        while(!s2.isEmpty()) {
            int sum = s2.pop().val;
            if(isCarry) sum++;
            if(sum > 9) {
                isCarry = true;
                sum %= 10;
            } else {
                isCarry = false;
            }

            ListNode newNode = new ListNode(sum);
            curr = newNode;
            curr.next = prev;
            prev = curr;
        }

        if(isCarry) {
            curr = new ListNode(1);
            curr.next = prev;
        }
        return curr;
    }
}