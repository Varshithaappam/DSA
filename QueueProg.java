import java.util.*;
class QueueProg{
    public static void main(String[] args){
        LinkedList<Integer> q=new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(80);
        q.add(60);
        System.out.println(q);
        q.remove();
        System.out.println(q);
        System.out.println(q.peek());
    }
}