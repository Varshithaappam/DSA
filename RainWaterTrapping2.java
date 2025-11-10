class RainWaterTrapping2{
    public static void main(String[] args) {
        int arr[] = {3, 0, 2, 0, 4};
        int n = arr.length;
        System.out.println(trap(arr, n));
    }
    static int trap(int h[],int n){
        int l = 0, r = n - 1;
        int maxl = 0, maxr = 0;
        int water = 0;
        while (l <= r) {
            if (h[l] <= h[r]) {
                if (h[l] >= maxl) {
                    maxl = h[l];
                } else {
                    water += maxl - h[l];
                }
                l++;
            } else {
                if (h[r] >= maxr) {
                    maxr = h[r];
                } else {
                    water += maxr - h[r];
                }
                r--;
            }
        }
        return water;
    }
}