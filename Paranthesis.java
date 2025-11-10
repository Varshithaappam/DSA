
import java.util.*;
class Paranthesis {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        int open[]=new int[n + 1];
        int close[]=new int[n + 1];
        open[0]=0;
        close[n]=0;
        for (int i=1;i<=n;i++) {
            open[i]=open[i-1];
            if (s.charAt(i-1)=='(')
                open[i]++;
        }
        for (int i=n-1;i>=0;i--) {
            close[i]=close[i+1];
            if (s.charAt(i)==')')
                close[i]++;
        }
        System.out.println("Open :  " + Arrays.toString(open));
        System.out.println("Close:  " + Arrays.toString(close));
        for(int i=n;i>=0;i--){
            if(open[i]==close[i]){
               System.out.println("equal point:  " + i); 
               break;
            }
        }
    }
}
