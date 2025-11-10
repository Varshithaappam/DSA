import java.util.*;

class Tickets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int allSingle = n * a;
        int SinglenSpecial = (n / m) * b + (n % m) * a;
        int allSpecial = (n / m + 1) * b;

        int totalCost1 = Math.min(allSingle, Math.min(SinglenSpecial, allSpecial));
        System.out.println(totalCost1);

        int arr[] = {5, 4, 1, 6, 8, 2, 7, 3};
        System.out.println(max2(arr));
        System.err.println(maxFreq(arr));
        sc.close();
    }

    static int max2(int arr[]) {
        int max = arr[0];
        int maxprev = Integer.MIN_VALUE;  // fixing initialization for second max
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                maxprev = max;
                max = arr[i];
            } else if (arr[i] > maxprev && arr[i] < max) {
                maxprev = arr[i];
            }
        }
        return maxprev;
    }

    static int maxFreq(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int maxCount = 0;
        for (int freq : map.values()) {
            if (freq > maxCount) {
                maxCount = freq;
            }
        }
        return maxCount;
    }
}
