package main.leetcode_solutions.search;

/**
 * @author wenzhuang
 * @date 2020/1/2 12:40 AM
 */
public class T529_Minesweeper{
    public char[][] updateBoard(char[][] board, int[] click) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        dfs(board, dirs, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int[][] dirs, int x, int y){
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length){
            return;
        }
        if (board[x][y] == 'M'){
            board[x][y] = 'X';
            return;
        }
        if (board[x][y] == 'E'){
            int count = 0;
            for (int[] dir : dirs){
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length){
                    if (board[nx][ny] == 'M'){
                        count++;
                    }
                }
            }
            if (count > 0){
                board[x][y] = (char) (count + '0');
                return;
            }
            board[x][y] = 'B';
            for (int[] dir : dirs){
                dfs(board, dirs, x + dir[0], y + dir[1]);
            }
        }
    }
}
