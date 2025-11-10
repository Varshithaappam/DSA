import java.util.*;
class PriorityQueueProg{
    public static void main(String[] args){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        //queue is not sorted but internally while removing the smallest number is removed 
        //when the pq is printed left center right.
        pq.add(8);
        pq.add(3);
        pq.add(10);
        pq.add(9);
        pq.add(20);
        pq.add(5);
        pq.add(22);
        System.out.println(pq.remove());
        while(!pq.isEmpty()){
            System.out.println(pq.remove());
        }
        System.out.println(pq.poll());
    }
}