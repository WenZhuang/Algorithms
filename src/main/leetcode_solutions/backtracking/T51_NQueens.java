package main.leetcode_solutions.backtracking;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2019/12/29 7:37 PM
 */
public class T51_NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        Set<Integer> cols = new HashSet<>();
        Set<Integer> sum = new HashSet<>();
        Set<Integer> sub = new HashSet<>();
        dfs(0, n, board, res, cols, sum, sub);
        return res;
    }

    private void dfs(int i, int n, char[][] board, List<List<String>> res, Set<Integer> cols, Set<Integer> sum, Set<Integer> sub){
        if (i == n){
            res.add(construct(board));
            return;
        }
        for (int j = 0; j < n; j++){
            if (!cols.contains(j) && !sum.contains(i + j) && !sub.contains(i - j)){
                cols.add(j);
                sum.add(i + j);
                sub.add(i - j);
                board[i][j] = 'Q';
                dfs(i + 1, n, board, res, cols, sum, sub);
                board[i][j] = '.';
                cols.remove(j);
                sum.remove(i + j);
                sub.remove(i - j);
            }
        }
    }

    private List<String> construct(char[][] board){
        List<String> subRes = new ArrayList<>();
        for (int i = 0; i < board.length; i++){
            subRes.add(new String(board[i]));
        }
        return subRes;
    }
}
