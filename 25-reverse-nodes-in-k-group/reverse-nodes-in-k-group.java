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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) return head;

        ListNode answer = new ListNode(-1);
        answer.next = head;
        ListNode kth = answer;
        ListNode prevG = answer;
        ListNode nextG = null;
        while(true) {
            kth = prevG;
            for(int i = 0;i<k && kth != null;i++)
                kth = kth.next;
            if(kth == null) break;

            nextG = kth.next;
            ListNode prev = nextG;
            ListNode curr = prevG.next;
            while(curr != nextG) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            ListNode temp = prevG.next;
            prevG.next = kth;
            prevG = temp;
        }
        return answer.next;
    }
}