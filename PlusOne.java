import java.util.*;
class PlusOne{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        int c=0,i=0;
        for( i=n-1;i>=0;i--){
            if(arr[i]<9){
            list.add(arr[i]+1);
            c=0;
            break;
            }
            else if(arr[i]==9){
                list.add(0);
                c=1;
            }
        }
        if(c==0){
            for(int j=i-1;j>=0;j--)
            list.add(arr[j]);
        }
        Collections.reverse(list);
        if(c==1)
        list.add(0,1);
        System.out.println(list);
    }
}