public class MainQueue{
    public static void main(String[] args) {
        CircularArrayQueue<Integer> q = new CircularArrayQueue<Integer>(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.displayQueue();
        System.out.println("Dequeued: " + q.dequeue());
        q.displayQueue();
    }
}