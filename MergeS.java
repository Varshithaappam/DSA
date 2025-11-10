// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class MergeS {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr[]=new int[n];
        int brr[]=new int[m];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        for(int i=0;i<m;i++)
        brr[i]=sc.nextInt();
        int l=0,r=0,k=0;
        int crr[]=new int[n+m];
        while(l< n && r<m){
            if(arr[l]<brr[r]){
                crr[k]=arr[l];
                l++;
            }
            else{
                crr[k]=brr[r];
                r++;
            }
            k++;
        }
        while(l<n){
            crr[k++]=arr[l++];
        }
        while(r<m){
            crr[k++]=brr[r++];
        }
        System.out.println(Arrays.toString(crr));
    }
}