public class CircularArrayQueue<T>{
    private T[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularArrayQueue(int capacity) {
        this.capacity = capacity;
        data = (T[])new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
    public int size(){
        return size;
    }
    public void enqueue(T value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        data[rear] = value;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T value = data[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return data[front];
    }

    public int getSize() {
        return size;
    }
    public void displayQueue(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        for(T i: data){
            System.out.print(i + " ");
        }
    }
}