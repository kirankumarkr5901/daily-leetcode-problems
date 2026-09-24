/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;

        Node node = head;
        while(node != null) {
            if(node.child != null) {
                Node next = node.next;
                node.next = flatten(node.child);
                node.child = null;
                node.next.prev = node;
                while(node.next != null) {
                    node = node.next;
                }
                node.next = next;
                if(next != null)
                    next.prev = node;
            }
            node = node.next;
        }
        return head;
    }
}