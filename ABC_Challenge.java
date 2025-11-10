import java.util.*;
public class ABC_Challenge
{
    static int calculateLCSLength(char[] source, char[] desired) {
        int n = source.length;
        int m = desired.length;
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(source[i-1]==desired[j-1])
                dp[i][j]=dp[i-1][j-1]+1;
                else
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int N=Integer.parseInt(sc.nextLine().trim());
        String rawItems[]=sc.nextLine().trim().split("\\s+");
        char initialOrder[]=new char[N];
        for(int i=0;i<N;i++)
        initialOrder[i]=rawItems[i].charAt(0);
        String fixed_Input="";
        if(sc.hasNextLine())
        fixed_Input=sc.nextLine().trim();
        int fixed_IndexSet[]=new int[0];
        if(!fixed_Input.isEmpty())
        {
            String f[]=fixed_Input.split("\\s+");
            fixed_IndexSet=new int[f.length];
            for(int i=0;i<f.length;i++)
            fixed_IndexSet[i]=Integer.parseInt(f[i]) - 1;
        }
        int countA=0,countB=0,countC=0;
        for(char ch:initialOrder)
        {
            if(ch=='A')
            countA++;
            else if(ch=='B')
            countB++;
            else
            countC++;
        }
        char ord_Perms[][]= {
                {'A', 'B', 'C'}, {'A', 'C', 'B'},
                {'B', 'A', 'C'}, {'B', 'C', 'A'},
                {'C', 'A', 'B'}, {'C', 'B', 'A'}
        };
        int minShifts=Integer.MAX_VALUE;
        for (char ord[]:ord_Perms)
        {
            int lenOfBlock[]={
                    ord[0]=='A'?countA:ord[0]=='B'?countB:countC,
                    ord[1]=='A'?countA:ord[1]=='B'?countB:countC,
                    ord[2]=='A'?countA:ord[2]=='B'?countB:countC
            };
            char target[]=new char[N];
            int index_fil=0;
            for(int i=0;i<3;i++)
            for(int k=0;k<lenOfBlock[i];k++)
            target[index_fil++]=ord[i];
            boolean valis=true;
            for(int index:fixed_IndexSet)
            {
                if(index<0 || index>=N || initialOrder[index]!=target[index])
                {
                    valis=false;
                    break;
                }
            }
            if(!valis)
            continue;
            int movesNeeded=N-calculateLCSLength(initialOrder,target);
            minShifts=Math.min(minShifts,movesNeeded);
        }
        if(minShifts==Integer.MAX_VALUE)
        System.out.print("Impossible");
        else
        System.out.print(minShifts);
        sc.close();
    }
}