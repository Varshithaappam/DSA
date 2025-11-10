import java.util.*;
class MaxEle{
    public static void main(String[] args){
        int max=Integer.MIN_VALUE,n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        list.add(sc.nextInt());
        for(int i=0;i<list.size();i++){
            if(max<list.get(i))
            max=list.get(i);
        }
        System.out.println(max);
    }
}