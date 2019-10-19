package main.the_beauty_of_data_structure_and_algorithm.algorithm.backtracking.example;

/**
 * @author wenzhuang
 * @date 2019-10-19 17:25
 */
public class NQueue {

    public void nQueue(int n){
        int[] pos = new int[n];
        for (int i = 0; i < n; i++){
            pos[i] = -1;
        }
        backtracking(pos, 0, n);
    }

    private void backtracking(int[] pos, int row, int n){
        if (row == n){
           printQueue(pos, n);
           return;
        }
        for (int col = 0; col < n; col++){
             if (valid(row, col, pos)){
                 pos[row] = col;
                 backtracking(pos, row + 1, n);
             }
        }
    }

    private boolean valid(int i, int j, int[] pos){
        for (int row = 0; row < i; row++){
            int col = pos[row];
            if (j == col || row + col == i + j || row - col == i - j){
                return false;
            }
        }
        return true;
    }

    private void printQueue(int[] pos, int n){
        for (int row = 0; row < n; row++){
            for (int col = 0; col < n; col++){
                if (pos[row] == col) {
                    System.out.print("Q ");
                } else {
                    System.out.print("# ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
