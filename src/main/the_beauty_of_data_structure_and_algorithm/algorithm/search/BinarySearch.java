package main.the_beauty_of_data_structure_and_algorithm.algorithm.search;

public class BinarySearch {
    public static int binarySearch(int[] a,int target) {
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

    public static int binarySearch2(int[] a, int target){
        if (a == null || a.length <= 0){
            return -1;
        }
        return binarySearch(a, 0, a.length - 1, target);
    }

    private static int binarySearch(int[] a, int low, int high, int target){
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

    public static int searchFirstEqual(int[] a, int target){
        if (a == null || a.length <= 0){
            return -1;
        }
        int low = 0, high = a.length - 1;
        while (low <= high){
            int mid = ((high - low) >> 1) + low;
            if (a[mid] == target){
                if (mid == 0 || a[mid - 1] != target){
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (a[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int searchLastEqual(int[] a, int target){
        if (a == null || a.length <= 0){
            return -1;
        }
        int low = 0, high = a.length - 1;
        while (low <= high){
            int mid = ((high - low) >> 1) + low;
            if (a[mid] == target){
                if (mid == a.length - 1 || a[mid + 1] != target){
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (a[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int searchFirstGreaterEqual(int[] a, int target){
        if (a == null || a.length <= 0){
            return -1;
        }
        int low = 0, high = a.length - 1;
        while (low <= high){
            int mid = ((high - low) >> 1) + low;
            if (a[mid] >= target){
                if (mid == 0 || a[mid - 1] < target){
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

    public static int searchLastLessEqual(int[] a, int target){
        if (a == null || a.length <= 0){
            return -1;
        }
        int low = 0, high = a.length - 1;
        while (low <= high){
            int mid = ((high - low) >> 1) + low;
            if (a[mid] <= target){
                if (mid == a.length - 1 || a[mid + 1] > target){
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
}
