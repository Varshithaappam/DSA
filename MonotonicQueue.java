import java.util.*;
class Queue{
    public static void main(String[] args){
        Queue<String> myQ=new LinkedList<String>();
        myQ.offer("apple");
        myQ.offer("banana");
        myQ.offer("cherry");
        myQ.offer("dragonfruit");
        System.out.println("Queue data: "+myQ);
        String head=myQ.peek();
        System.out.println("Queue head: "+head);
        String poppedele=myQ.remove();
        System.out.println("Queue poppedele: "+poppedele);
        System.out.println("Queue data: "+myQ);
        String polledele=myQ.poll();
        System.out.println("Queue polledele: "+polledele);
        System.out.println("Queue data: "+myQ);
    }
}