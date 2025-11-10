class RainWaterTrappingSolution {
    public static void main(String[] args) {
        int arr[]={3,0,2,0,4};
        System.out.println(trap(arr));
    }
    /**
     * Calculates the total amount of trapped rainwater given an elevation map.
     *
     * This method uses dynamic programming to precompute the maximum height to the left and right
     * of each bar, then calculates the water trapped at each position as the minimum of the left and
     * right maximums minus the height at that position.
     *
     * @param height an array of non-negative integers representing the elevation map where the width of each bar is 1
     * @return the total amount of trapped rainwater
     */
    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // update left max
                } else {
                    water += leftMax - height[left]; // water trapped
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // update right max
                } else {
                    water += rightMax - height[right]; // water trapped
                }
                right--;
            }
        }
        return water;
    }
}