class MyCircularQueue {

    int capacity;
    int[] queue;
    int front;
    int rear; 
    int currentSize;

    public MyCircularQueue(int k) {
        queue = new int[k];
        capacity = k;
        front = 0;
        rear = -1;
        currentSize = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        this.rear = (this.rear+1) % this.capacity;
        this.queue[this.rear] = value;
        this.currentSize++;
        return true;

    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        this.front = (this.front+1) % this.capacity;
        this.currentSize--;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : this.queue[this.front];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : this.queue[this.rear];
    }
    
    public boolean isEmpty() {
        return this.currentSize == 0;
    }
    
    public boolean isFull() {
        return this.currentSize == this.capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */