import java.util.*;
class Deque{
    public static void main(String[] args){
        Deque<Integer> dq = new ArrayDeque<>();

        // Add elements
        dq.add(10);
        dq.add(20);
        dq.add(30);
        dq.addFirst(5);
        dq.addLast(40);

        System.out.println("Deque after additions: " + dq);

        // Offer methods (return boolean)
        dq.offer(50);
        dq.offerFirst(1);
        dq.offerLast(60);
        System.out.println("After offer methods: " + dq);

        // Peek methods (retrieve without removing)
        System.out.println("peek(): " + dq.peek());
        System.out.println("peekFirst(): " + dq.peekFirst());
        System.out.println("peekLast(): " + dq.peekLast());

        // Get methods (retrieve without removing, throw exception if empty)
        System.out.println("getFirst(): " + dq.getFirst());
        System.out.println("getLast(): " + dq.getLast());

        // Remove methods (remove and return)
        System.out.println("remove(): " + dq.remove());
        System.out.println("removeFirst(): " + dq.removeFirst());
        System.out.println("removeLast(): " + dq.removeLast());
        System.out.println("Deque after removes: " + dq);

        // Poll methods (remove and return, null if empty)
        System.out.println("poll(): " + dq.poll());
        System.out.println("pollFirst(): " + dq.pollFirst());
        System.out.println("pollLast(): " + dq.pollLast());
        System.out.println("Deque after polls: " + dq);

        // Push and Pop (like Stack)
        dq.push(100);
        dq.push(200);
        System.out.println("After push: " + dq);
        System.out.println("pop(): " + dq.pop());
        System.out.println("After pop: " + dq);

        // Contains and size
        System.out.println("Contains 10? " + dq.contains(10));
        System.out.println("Size: " + dq.size());

        // Iterate forward and backward
        System.out.print("Forward iteration: ");
        for (int x : dq) System.out.print(x + " ");
        System.out.println();

        System.out.print("Reverse iteration: ");
        Iterator<Integer> it = dq.descendingIterator();
        while (it.hasNext()) System.out.print(it.next() + " ");
        System.out.println();

        // Clear deque
        dq.clear();
        System.out.println("After clear: " + dq);
    }
}



