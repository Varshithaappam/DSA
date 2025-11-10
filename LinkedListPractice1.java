public class LinkedListPractice1{
    static class Node{
    int data;
    Node next;
    Node(int x){
        this .data=x;
        this.next=null;
    }
    }
    Node head;
    public void addBack(int x){
        if(head==null)
        head=new Node(x);
        else{
            Node t=head;
            while(t.next!=null){
                t=t.next;
            }
            t.next=new Node(x);
        }
    }
    public void display(){
        Node t=head;
        while(t!=null){
            System.out.print(t.data+"->");
            t=t.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public void addFront(int val){
        Node newNode=new Node(val);
        if(head==null)
        head=newNode;
        else{
        newNode.next=head;
        head=newNode;
        }
    }
    public int sum(){
        if(head==null)
        return 0;
        Node t=head;
        int sum=0;
        while(t!=null){
            sum+=t.data;
            t=t.next;
        }
        return sum;
    }
    public void middleNode(){
        Node f=head;
        Node s=head;
        while(f!=null && f.next!=null){
            f=f.next.next;
            s=s.next;
        }
        System.out.println(s.data);
    }
    public void middleNode1(){
        Node t=head;
        int c=0;
        while(t!=null){
            c++;
            t=t.next;
        }
        int m=0;
        t=head;
        while(t!=null){
            m++;
            t=t.next;
            if(m==c/2){
                break;
            }
        }
        System.out.println(t.data);
    }
    public Node KthNode(int k){
        Node t=head;
        int c=0;
        while(t!=null){
            c++;
            t=t.next;
        }
        int m=0;
        t=head;
        while(t!=null){
            m++;
            t=t.next;
            if(m==c-k){
                break;
            }
        }
        return t;
    }
    public Node KthNode2(int k){
        Node f=head;
        Node s=head;
        while(k>0){
            f=f.next;
            k--;
        }
        while(f!=null){
            f=f.next;
            s=s.next;
        }
        return s;
    }
    public static void main(String[] args){
        LinkedListPractice1 sll=new LinkedListPractice1();
        sll.addBack(10);
        sll.addBack(20);
        sll.addBack(30);
        sll.addBack(40);
        sll.display();
        System.out.println("---------------------------------------");
        sll.addFront(100);
        sll.addFront(200);
        sll.addFront(300);
        sll.addFront(400);
        sll.display();
        System.out.println("---------------------------------------");
        System.out.println("sll.sum(): "+sll.sum());
        System.out.println("---------------------------------------");
        sll.middleNode();
        System.out.println("---------------------------------------");
        sll.middleNode1();
        System.out.println("---------------------------------------");
        System.out.println("sll.KthNode(3).data: "+sll.KthNode(3).data);
        System.out.println("---------------------------------------");
        System.out.println("sll.KthNode2(3).data: "+sll.KthNode2(3).data);
        System.out.println("---------------------------------------");
    }
}