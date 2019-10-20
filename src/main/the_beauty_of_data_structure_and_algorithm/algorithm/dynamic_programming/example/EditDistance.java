package main.the_beauty_of_data_structure_and_algorithm.algorithm.dynamic_programming.example;

/**
 * 编辑距离
 * @author wenzhuang
 * @date 2019-10-20 13:45
 */
public class EditDistance {

    public int editDistance(char[] a, char[] b){
        int m = a.length, n = b.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++){
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++){
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++){
                if (a[i - 1] == b[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        //倒退，打印编辑过程，算法解中非必须的过程
        int i = m, j = n;
        while (i > 0 && j > 0){
            print(a, i);
            print(b, j);
            System.out.println();
            if (a[i - 1] == b[j - 1]){
                i--;
                j--;
            } else {
                if (dp[i - 1][j - 1] + 1 == dp[i][j]){
                    i--;
                    j--;
                } else if (dp[i - 1][j] + 1 == dp[i][j]){
                    i--;
                } else {
                    j--;
                }
            }
        }
        print(a, i);
        print(b, j);
        return dp[m][n];
    }

    private void print(char[] a, int index){
        for (int i = 0; i <= index - 1; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
