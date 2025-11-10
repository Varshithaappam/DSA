/**
 * The CopilotDemo class demonstrates several sorting algorithms and subarray printing in Java.
 * <p>
 * Features:
 * <ul>
 *   <li>Sorts an integer array using Merge Sort and prints the sorted array.</li>
 *   <li>Sorts another integer array using Bubble Sort and prints the sorted array.</li>
 *   <li>Prints all possible subarrays of the first array.</li>
 * </ul>
 *
 * Methods:
 * <ul>
 *   <li>{@code main(String[] args)}: Entry point of the program. Demonstrates sorting and subarray printing.</li>
 *   <li>{@code bubbleSort(int[] arr)}: Sorts the given array using the Bubble Sort algorithm and prints the sorted array.</li>
 *   <li>{@code mergeSort(int[] arr, int left, int right)}: Recursively sorts the array using the Merge Sort algorithm.</li>
 *   <li>{@code merge(int[] arr, int left, int mid, int right)}: Merges two sorted subarrays into a single sorted subarray.</li>
 *   <li>{@code printSubArrays(int[] arr, int n)}: Prints all possible subarrays of the given array.</li>
 * </ul>
 */
class CopilotDemo{
    public static void main(String[] args) {
        int arr[] = {2, -1, 3, 6, 1};
        mergeSort(arr, 0, arr.length - 1);
        for(int num:arr){
            System.out.print(num+" ");
        }
        System.out.println();
        int brr[] = {2, 1, 5, 6, 1};
        bubbleSort(brr);
        System.out.println();
        printSubArrays(arr,arr.length);
        linearSearch(arr,3);
        binarySearch(arr,6);
    }
    static void bubbleSort(int arr[]){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        for(int num:arr){
            System.out.print(num+" ");
        }
        
    }
    static void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    static void merge(int arr[], int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) {
            arr[k++] = L[i++];
        }
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }
    static void printSubArrays(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    static void linearSearch(int arr[], int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                System.out.println("Element found at index: "+i);
                return;
            }
        }
        System.out.println("Element not found");
    }
    static void binarySearch(int arr[], int key){
        int left=0,right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==key){
                System.out.println("Element found at index: "+mid);
                return;
            }
            if(arr[mid]<key){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        System.out.println("Element not found");
    }
}