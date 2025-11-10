import java.util.*;
class LRDiff{
    public static void main(String[] args) {
        int arr[]=new int[]{2,5,1,6,3,4};
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        int ls=0,rs=sum;
        int brr[]=new int[n];
        for(int i=0;i<n;i++){
            brr[i]=Math.abs(rs-ls-arr[i]);
            ls+=arr[i];
            rs-=arr[i];
        }
        System.out.println(Arrays.toString(brr));
    }
}