import java.util.*;
class Problem3{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        list.add(sc.nextInt());
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(!res.contains(list.get(i)))
            res.add(list.get(i));
        }
        System.out.println(res);
    }
}