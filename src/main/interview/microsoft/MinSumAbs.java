package main.interview.microsoft;

/**
 * @author wenzhuang
 * @date 2020-03-23 15:54
 */

/**
 * Find minimum abs(val[a]+val[b]) in an integer array, a and b is different.
 */
public class MinSumAbs {

    public int minAbs(int[] arr, int t){
        int less = findLess(arr, -t);
        int large = findLarge(arr, -t);
        int min = Integer.MAX_VALUE;
        if (less != -1 && Math.abs(t + arr[less]) < min){
            min = Math.abs(t + arr[less]);
        }
        if (large != -1 && Math.abs(t + arr[large]) < min){
            min = Math.abs(t + arr[large]);
        }
        return min;
    }

    private int findLess(int[] arr, int t){
        int low = 0, high = arr.length - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (arr[mid] <= t){
                if (mid == arr.length - 1 || arr[mid + 1] > t){
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int findLarge(int[] arr, int t){
        int low = 0, high = arr.length - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= t){
                if (mid == 0 || arr[mid - 1] < t){
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
