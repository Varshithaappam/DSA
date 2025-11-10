import java.util.*;
class Problem2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        if(arr[i]%2==0)
        list.add(arr[i]);
        System.out.println(Arrays.toString(list.toArray()));
    }
}