/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack();
        Stack<ListNode> stackB = new Stack();

        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while(nodeA != null) {
            stackA.add(nodeA);
            nodeA = nodeA.next;
        }
        while(nodeB != null) {
            stackB.add(nodeB);
            nodeB = nodeB.next;
        }
        ListNode answerNode = null;
        while(!stackA.isEmpty() && !stackB.isEmpty() && stackA.peek() == stackB.peek()) {
            answerNode = stackA.pop();
            stackB.pop();
        }
        return answerNode;
    }
}