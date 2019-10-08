package main.the_beauty_of_data_structure_and_algorithm.algorithm.search;

public class BinarySearch {
    public int binarySearch(int[] a,int target) {
        if (a == null || a.length <= 0){
            return -1;
        }
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = ((high - low) >> 1) + low;
            if (a[mid] == target){
                return mid;
            } else if (a[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int binarySearch2(int[] a, int target){
        if (a == null || a.length <= 0){
            return -1;
        }
        return binarySearch(a, 0, a.length - 1, target);
    }

    private int binarySearch(int[] a, int low, int high, int target){
        if (low > high){
            return -1;
        }
        int mid = ((high - low) >> 1) + low;
        if (a[mid] == target){
            return mid;
        } else if (a[mid] < target){
            return binarySearch(a, mid + 1, high, target);
        } else {
            return binarySearch(a, low, mid - 1, target);
        }
    }
}
