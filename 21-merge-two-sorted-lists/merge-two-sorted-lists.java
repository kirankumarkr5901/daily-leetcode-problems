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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        else if(list1 == null) return list2;
        else if(list2 == null) return list1;

        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode head = null;
        ListNode prev = null;

        while(node1 != null && node2 != null) {
            if(head == null) {
                if(node1.val < node2.val) {
                    head = node1;
                    prev = node1;
                    node1 = node1.next;
                } else {
                    head = node2;
                    prev = node2;
                    node2 = node2.next;
                }
            } else {
                if(node1.val < node2.val) {
                    prev.next = node1;
                    prev = node1;
                    node1 = node1.next;
                } else {
                    prev.next = node2;
                    prev = node2;
                    node2 = node2.next;
                }
            }
        }
        if(node1 == null) {
            prev.next = node2;
        } else {
            prev.next = node1;
        }
        return head;
    }
}