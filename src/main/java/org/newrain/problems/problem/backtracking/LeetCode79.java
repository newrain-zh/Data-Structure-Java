package org.newrain.problems.problem.backtracking;

/**
 * 单词搜索
 */
public class LeetCode79 {

    private String  word;
    private boolean ans;
    private int     m;
    private int     n;
    private int     index;


    /**
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        this.word  = word;
        this.m     = board.length;
        this.n     = board[0].length;
        this.index = index;
        backtracking(board, 0, 0, new StringBuilder());
        return ans;
    }

    /**
     * ❌解法
     *
     * @param board
     * @param row
     * @param col
     * @param path
     */
    public void backtracking(char[][] board, int row, int col, StringBuilder path) {
        System.out.println(path.toString());
        if (path.toString().equals(word)) {
            ans = true;
            return;
        }
        if (row < m && col < n && index < word.length()) {
            if (board[row][col] == word.charAt(index)) { // 按列找
                path.append(word.charAt(index));
                backtracking(board, row + 1, col, path);
                index++;
                path = new StringBuilder(path.substring(0, path.length() - 1));
            }
            if (board[row][col] == word.charAt(index)) { // 按行找
                path.append(word.charAt(index));
                backtracking(board, row, col + 1, path);
                index++;
                path = new StringBuilder(path.substring(0, path.length() - 1));

            }
        }
    }

    public boolean exist1(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char[] array = word.toCharArray();
                if (board[i][j] == array[0]) {
                    if (dfs(board, i, j, word.toCharArray(), 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public boolean dfs(char[][] board, int row, int col, char[] word, int index) {
        if (index == word.length - 1) {
            return true;
        }
        // 保存当前字符并标记为已访问（用特殊字符占位）
        char original = board[row][col];
        board[row][col] = '#';
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int x = direction[0] + row;
            int y = direction[1] + col;
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == word[index + 1]) {
                if (dfs(board, x, y, word, index + 1)) {
                    board[row][col] = original;
                    return true;
                }
            }
        }
        board[row][col] = original;
        return false;
    }


    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(new LeetCode79().exist1(board, "ABCCED"));
//        StringBuilder path = new StringBuilder("ABCCE");
//        path = new StringBuilder(path.substring(0, path.length() - 1));
//        System.out.println(path.toString());


    }
}