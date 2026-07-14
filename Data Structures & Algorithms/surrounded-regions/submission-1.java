class Solution {
    public void solve(char[][] board) {
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    if (((i - 1) < 0) || ((i + 1) == board.length) || ((j - 1) < 0)
                        || ((j + 1) == board[0].length)) {
                        board[i][j] = 'P';
                        q.offer(new int[] {i, j});
                    }
                }
            }
        }

        while (q.size() != 0) {
            int item[] = q.poll();
            int i = item[0];
            int j = item[1];

            // left
            if ((i - 1) >= 0) {
                if (board[i - 1][j] == 'O') {
                    board[i - 1][j] = 'P';
                    q.offer(new int[] {i - 1, j});
                }
            }

            //    right
            if ((i + 1) < board.length) {
                // System.out.println("inside i = "+ i + " j "+ j);
                if (board[i + 1][j] == 'O') {
                    board[i + 1][j] = 'P';
                    q.offer(new int[] {i + 1, j});
                }
            }

            //  top
            if ((j - 1) >= 0) {
                if (board[i][j - 1] == 'O') {
                    board[i][j - 1] = 'P';
                    q.offer(new int[] {i, j - 1});
                }
            }
            // below
            if ((j + 1) < board[0].length) {
                if (board[i][j + 1] == 'O') {
                    board[i][j + 1] = 'P';
                    q.offer(new int[] {i, j + 1});
                }
            }
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if(board[i][j] == 'O'){
                            board[i][j] = 'X';
                }
                
            }
        }

         for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if(board[i][j] == 'P'){
                    board[i][j] = 'O';
                }
                // System.out.print(board[i][j] + " ");
            }
            // System.out.println();
         }
    }
}
