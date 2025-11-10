import java.util.*;
class ArrangeOddEven{
    public static void main(String[] args){
        int arr[]={5,4,7,1,3,2,8,9,5};
        System.out.println("Actual Array:  "+Arrays.toString(arr));
        Quick(arr,0,arr.length-1);
        System.out.println("Array after arranging even and odd:  "+Arrays.toString(arr));
        int k=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==1){
                k=i;
                break;
            }
        }
        Arrays.sort(arr,0,k);
        Arrays.sort(arr,k,arr.length);
        System.out.println("Array after sorting the arranged even and odd array:  "+Arrays.toString(arr));
    }
    static void Quick(int arr[],int low,int high){
        if (low < high) {
            int p = Partition(arr, low, high);
            Quick(arr, low, p - 1);
            Quick(arr, p + 1, high);
        }
    }
    static int Partition (int arr[],int low,int high){
         int k=low-1;
         int pivot=arr[high];
        for(int i=low;i<high;i++){
            if(arr[i]%2<pivot%2){
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