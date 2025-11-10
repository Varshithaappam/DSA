class Prefix{
    public static void main(String[] args){
        int arr[] = {1,2,6,3,5};
        int prefix[] = prefixSum(arr);
        for(int i: prefix){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(rangeSum(prefix, 1, 3));
        System.out.println(minSizeSubarray(arr, 9));
        int res[] = circularArray(arr,2);
        System.out.println("circular array from index 2:");
        for(int i: res){
            System.out.print(i + " ");
        }
    }
    static int[] prefixSum(int arr[]){
        int n = arr.length;
        int prefix[] = new int[n];
        prefix[0] = arr[0];
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        return prefix;
    }
    static int rangeSum(int prefix[], int left, int right){
        if(left == 0){
            return prefix[right];
        }
        return prefix[right] - prefix[left - 1];
    }
    static int minSizeSubarray(int arr[],int target){
        int sum=0;
        int min=Integer.MAX_VALUE;
        int l=0;
        for(int r=0;r<arr.length;r++){
            sum+=arr[r];
            while(sum>target){
                sum-=arr[l];
                l++;
            }
            if(sum==target){
                min = Math.min(min,r-l+1);
            }
        }
        return min;
    }
    static int[] circularArray(int arr[],int k){
        int n = arr.length;
        int res[] = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = arr[(k + i) % n];
        }
        return res;
    }
    
}