/**
 * The Program class demonstrates the implementation of the Merge Sort algorithm in Java.
 * <p>
 * It contains the following methods:
 * <ul>
 *   <li><b>main</b>: Initializes an integer array, sorts it using merge sort, and prints the sorted array.</li>
 *   <li><b>mergeSort</b>: Recursively divides the array into subarrays and sorts them using the merge function.</li>
 *   <li><b>merge</b>: Merges two sorted subarrays into a single sorted subarray.</li>
 * </ul>
 * 
 * <p>
 * Example usage:
 * <pre>
 * int arr[] = {2, 1, 3, 6, 1};
 * mergeSort(arr, 0, arr.length - 1);
 * // arr is now sorted: [1, 1, 2, 3, 6]
 * </pre>
 * </p>
 */
class Program {
    public static void main(String[] args) {
        int arr[] = {2, 1, 3, 6, 1};
        mergeSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
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
}