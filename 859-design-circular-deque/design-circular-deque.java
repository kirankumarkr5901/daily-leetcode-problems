class MyCircularDeque {

    int[] queue;
    int capacity;
    int currentSize;
    int front;
    int rear;

    public MyCircularDeque(int k) {
        queue = new int[k];
        capacity = k;
        currentSize = 0;
        front = k-1;
        rear = 0;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        front = (front+1) % capacity;
        queue[front] = value;
        currentSize++;
        return true;

    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        System.out.print("Rear: "+rear);
        rear = (rear - 1 + capacity) % capacity;
        System.out.println(" -> "+rear);
        queue[rear] = value;
        currentSize++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        front = (front - 1 + capacity) % capacity;
        currentSize--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        rear = (rear+1) % capacity;
        currentSize--;
        return true;
    }
    
    public int getFront() {
        return isEmpty() ? -1 : queue[front];
    }
    
    public int getRear() {
        return isEmpty() ? -1 : queue[rear];
    }
    
    public boolean isEmpty() {
        return currentSize == 0;
    }
    
    public boolean isFull() {
        return currentSize == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */