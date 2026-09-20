
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class MyLinkedList {

    int size;
    ListNode head;

    public MyLinkedList() {
        this.size = 0;
        this.head = null;
    }
    
    public int get(int index) {
        if(index >= this.size) return -1;
        ListNode node = this.head;
        while(index > 0) {
            node = node.next;
            index--;
        }
        return node.val;
    }
    
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;

    }
    
    public void addAtTail(int val) {
        if(this.head == null) {
            addAtHead(val);
            return;
        }
        ListNode node = this.head;
        while(node.next != null) node = node.next;
        ListNode newNode = new ListNode(val);
        node.next = newNode;
        this.size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > this.size) return;
        if(index == 0) addAtHead(val);
        else if(index == this.size) addAtTail(val);
        else {
            ListNode node = this.head;
            while(index > 1) {
                index--;
                node = node.next;
            }
            ListNode newNode = new ListNode(val);
            this.size++;
            newNode.next = node.next;
            node.next = newNode;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index >= this.size) return;
        if(index == 0) {
            this.head = this.head.next;
        } else {
            ListNode node = this.head;
            while(index > 1) {
                index--;
                node = node.next;
            }
            node.next = node.next.next;
        }
        this.size--;
        if(this.size == 0) {
            this.head = null;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */