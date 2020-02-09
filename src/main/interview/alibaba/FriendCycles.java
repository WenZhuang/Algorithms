package main.interview.alibaba;

/**
 * 假如已知有n个人和m对好友关系。如果两个人是直接或间接的好友（好友的好友的好友...），则认为他们属于同一个朋友圈，求：
 * 给定x, y 属于n中的2个人，判断其是否处于同一个朋友圈
 * 这n个人中一共有多少个朋友圈
 */
/**
 * @author wenzhuang
 * @date 2020/1/21 7:51 PM
 */
public class FriendCycles {

    public static void main(String[] args){
        int[][] M = {};
        FriendCycles friendCycles = new FriendCycles();
        System.out.println(friendCycles.isFirend(M, 1, 2));
        System.out.println(friendCycles.findCircleNum(M));
    }

    //是否好友
    private boolean isFirend(int[][] M, int x, int y){
        int N = M.length;
        int[] visited = new int[N];
        return dfs(M, visited, x, y);
    }


    private boolean dfs(int[][] M, int[] visited, int x, int y){
        for (int j = 0; j < M.length; j++){
            if (M[x][j] == 1 && visited[j] == 0){
                if (j == y){
                    return true;
                }
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
        return false;
    }

    //朋友圈的个数
    private int findCircleNum(int[][] M) {
        int N = M.length;
        int[] visited = new int[N];
        int count = 0;
        for (int i = 0; i < N; i++){
            if (visited[i] == 0){
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int[] visited, int i){
        for (int j = 0; j < M.length; j++){
            if (M[i][j] == 1 && visited[j] == 0){
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}
