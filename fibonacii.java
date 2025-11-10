import  java.util.*;
class fibonacii{
    static int fibon(int n,int dp[]){
        if(n==0) return dp[0]=0;
        if(n==1) return dp[1]=1;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=fibon(n-1,dp)+fibon(n-2,dp);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int n1=0,n2=1;
        int dp[]=new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(fibon(n,dp));
    }
}