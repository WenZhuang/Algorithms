package main.leetcode_solutions.leetcode_solutions;

/**
 * @author wenzhuang
 * @date 2019-10-03 03:22
 */
/**
 * 二分法, k与第k大的数单调正相关
 * 对每行矩阵寻找小于对应数字，再次使用二分法
 * 两次使用二分
 **/
public class T378_KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int L = matrix[0][0];
        int R = matrix[n - 1][n - 1];
        int ans = 0;
        while(L <= R){
            int mid = (R - L) / 2 + L;
            if(guess(mid, matrix, k)){
                ans = mid;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        return ans;
    }

    private boolean guess(int t, int[][] matrix, int k){
        int n = matrix.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            int ans = -1;
            int R = n - 1;
            int L = 0;
            while(L <= R){
                int mid = (R - L) / 2 + L;
                if(matrix[i][mid] < t){
                    ans = mid;
                    L = mid + 1;
                }else{
                    R = mid - 1;
                }
            }
            sum += ans + 1;
        }
        return k > sum;
    }
}
