public class LinkedListPractice{
    static class Node{
    int data;
    Node next;
    Node(int x){
        this .data=x;
        this.next=null;
    }
    }
    public void display(Node x){
        Node t=x;
        while(t!=null){
            System.out.println(t.data+" ");
            t=t.next;
        }
    }
    public int sum(Node x){
        Node t=x;
        int sum=0;
        while(t!=null){
            sum+=t.data;
            t=t.next;
        }
        return sum;
    }
    public void addBack(Node x,int val){
        Node t=x;
        while(t.next!=null){
            t=t.next;
        }
        t.next= new Node(val);
    }
    public Node addFront(int val,Node a){
        Node newNode=new Node(val);
        newNode.next=a;
        a=newNode;
        return a;
    }
    public static void main(String[] args){
        Node a=new Node(10);
        LinkedListPractice sll=new LinkedListPractice();
        System.out.println(a.data+" "+a.next);
        // System.out.println(a.data+" "+a.next);
        // System.out.println(a.next.data+" "+a.next.next);
        sll.display(a);
        sll.addBack(a, 20);
        sll.addBack(a, 30);
        sll.addBack(a, 40);
        sll.display(a);
        System.out.println(sll.sum(a));
        
        a = sll.addFront(50,a);
        sll.display(a);
    }
}