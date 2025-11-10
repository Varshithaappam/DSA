import java.util.*;
class BubbleSort{
    public static void main(String[] args) {
        int arr[]=new int[]{5,1,4,2,8};
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int flag=0;
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=1;
                }
            }
            if(flag==0) break;
        }
        System.out.println(Arrays.toString(arr));
    }
}