package Solution250_300;

///感觉以后做题要开始刷了，不然效率太低了，因为不能确定到底有没有trick还是工程上的难题
class Solution289 {
    public void gameOfLife(int[][] board) {
        int[][] dir ={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int live = 0;
                for(int[] d : dir) {
                    if (d[0]+i < 0 || d[0]+i >= board.length || d[1]+j < 0 || d[1]+j >=board[0].length) continue;
                    if (board[d[0]+i][d[1]+j] == 1 || board[d[0]+i][d[1]+j] == 2) live++;
                }

                if (board[i][j] == 0 && live == 3) board[i][j] = 3;
                if (board[i][j] == 1 && (live < 2 || live > 3)) board[i][j] = 2;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] %= 2;
            }
        }
    }
}
