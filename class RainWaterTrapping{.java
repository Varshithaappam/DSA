class RainWaterTrapping{
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
    static int trap(int[] height) {
        int n=height.length;
        int left[]=new int[n];
        int right[]=new int[n];
        left[0]=height[0];
        for(int i=1;i<n;i++){
            left[i]=Math.max(left[i-1],height[i]);
        }
        right[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            right[i]=Math.max(right[i+1],height[i]);
        }
        int water=0;
        for(int i=0;i<n;i++){
            water+=Math.min(left[i],right[i])-height[i];
        }
        return water;
    }
}