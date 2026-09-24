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
        ListNode answer = new ListNode();
        ListNode node = answer;

        boolean isCarry = false;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if(isCarry) sum++;
            if(sum > 9) {
                isCarry = true;
                sum %= 10;
            } else {
                isCarry = false;
            }
            ListNode newNode = new ListNode(sum);
            node.next = newNode;
            node = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int sum = l1.val;
            if(isCarry) sum++;
            if(sum > 9) {
                isCarry = true;
                sum %= 10;
            } else {
                isCarry = false;
            }
            ListNode newNode = new ListNode(sum);
            node.next = newNode;
            node = newNode;
            l1 = l1.next;
        }

        while(l2 != null) {
            int sum = l2.val;
            if(isCarry) sum++;
            if(sum > 9) {
                isCarry = true;
                sum %= 10;
            } else {
                isCarry = false;
            }
            ListNode newNode = new ListNode(sum);
            node.next = newNode;
            node = newNode;
            l2 = l2.next;
        }

        if(isCarry) node.next = new ListNode(1);

        return answer.next;
    }
}