import java.util.*;
class List2D{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        int k=0;
        for(int i=0;i<3;i++){
            arr.add(new ArrayList<>());
            for(int j=0;j<3;j++)
            arr.get(i).add(sc.nextInt());
        }
        System.out.println(arr);
        
    }
}