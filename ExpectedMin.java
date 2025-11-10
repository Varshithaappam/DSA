import java.util.*;
// public interface Myinterface{
//     public abstract int getElement(int []input,int expected){
        
//     }
// }
class InvalidExpected extends Exception {
    public InvalidExpected(String m) {
        super(m);
    }
}
class ExpectedMin{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int expected=sc.nextInt();
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        Arrays.sort(arr);
        int min1=arr[0];
        int c=1;
        if(c==expected)
        System.out.println(min1);
        for(int i=1;i<n;i++){
            if(arr[i-1]!=arr[i]){
                c++;
                if(c==expected)
                System.out.println(arr[i]);
            }
        }
        sc.close();
        if(expected>c )
        try{
            throw new InvalidExpected("invalid expected");
        }
        catch(InvalidExpected ex){
            System.out.println(ex.getMessage());  
        }
       
    }
}