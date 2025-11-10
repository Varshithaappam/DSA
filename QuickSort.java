import java.util.*;
class QuickSort{
    public static void main(String[] args){
        int arr[]={5,4,7,1,3,2,8,9,4};
        Quick(arr,0,8);
        System.out.println(Arrays.toString(arr));
    }
    static void Quick(int arr[],int low,int high){
        if (low < high) {
            int p = QuickPartition(arr, low, high);
            Quick(arr, low, p - 1);
            Quick(arr, p + 1, high);
        }
    }
    static int QuickPartition(int arr[],int low,int high){
        int k=low-1,pivot=arr[high];
        for(int i=low;i<high;i++){
            if(arr[i]<=pivot){
                k++;
                int temp=arr[k];
                arr[k]=arr[i];
                arr[i]=temp;
            }
        }
        k++;
        int temp=arr[k];
        arr[k]=arr[high];
        arr[high]=temp;
        return k;
    }
}