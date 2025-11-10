import java.util.*;
class Sum{
    public static void main(String[] args){
        // int sum=0,n;
        // Scanner sc=new Scanner(System.in);
        // n=sc.nextInt();
        // int arr[]=new int[n];
        // for(int i=0;i<n;i++)
        // arr[i]=sc.nextInt();
        // for(int i=0;i<arr.length;i++)
        // sum+=arr[i];
        // System.out.println(sum);
        ArrayList<Integer> list=new ArrayList<>();
        list.add(50);
        list.add(10);
        list.add(20);
        list.add(30);
        for(int i:list)
        System.out.print(i+" ");
        System.out.println("\n-----------------------------------");
        list.add(2,200);
        for(int i:list)
        System.out.print(i+" ");
        System.out.println("\n-----------------------------------");
        for(int i=0;i<list.size();i++)
        System.out.print(list.get(i)+" ");
        System.out.println("\n-----------------------------------");
        list.set(2,300);
        for(int i=0;i<list.size();i++)
        System.out.print(list.get(i)+" ");
        System.out.println("\n-----------------------------------");
        list.remove(2);
        for(int i=0;i<list.size();i++)
        System.out.print(list.get(i)+" ");
        System.out.println("\n-----------------------------------");
        System.out.print(list.size());
        System.out.println("\n-----------------------------------");
    }
}