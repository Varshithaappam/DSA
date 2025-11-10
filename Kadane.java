class Kadane{
    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        int k=3;
        System.out.println(maxSubArraySum(arr,k));
    }
    static int maxSubArraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < k) return 0;
        int maxSum = 0, windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        maxSum = windowSum;
        for (int i = k; i < n; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}