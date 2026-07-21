class Solution {
    public int longestIncreasingPath(int[][] matrix) {
   
        int memo[][] = new int[matrix.length][matrix[0].length];
        for (int row[] : memo) {
            Arrays.fill(row, -1);
        }

        // encoreReturLongest(matrix, visited, 0, 0);
        int max = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // System.out.println("enter the loop: "+ i+ " "+ j);
                max = Math.max(max, encoreReturLongest(matrix, i, j, memo));
            }
        }

        return max;
    }

    public int encoreReturLongest(int[][] matrix, int i, int j, int memo[][]) {
        int res = 1;

        if (i == matrix.length || j == matrix[0].length) {
            return 0;
        }

        if (i < 0 || j < 0) {
            return 0;
        }


        if( memo[i][j] != -1){
            return  memo[i][j];
        }



        // System.out.println("elemet: " + matrix[i][j]+ " ij "+ i+ " "+j);

        // left
        if ((j + 1) < matrix[0].length
            && matrix[i][j + 1] > matrix[i][j]) {
            res = Math.max(1 + encoreReturLongest(matrix, i, j + 1, memo), res);
            // System.out.println(matrix[i][j] + " ij " + i + " " + j + " res: " + res);
        }

        // down
        if ((i + 1) < matrix.length
            && matrix[i + 1][j] > matrix[i][j]) {
            // System.out.println(matrix[i][j] + " ij " + i + " " + j + " res before: " + res);
            int res2 = 1 + encoreReturLongest(matrix, i + 1, j, memo);
            // System.out.println(matrix[i][j] + " ij " + i + " " + j + " res2 aftr: " + res2);
            res = Math.max(res, res2);
        }

        // System.out.println("max is: " + res);

        // right
        if ((j - 1) >= 0  && matrix[i][j - 1] > matrix[i][j]) {
            res = Math.max(1 + encoreReturLongest(matrix, i, j - 1, memo), res);
        }

        // down
        if ((i - 1) >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            res = Math.max(1 + encoreReturLongest(matrix, i - 1, j, memo), res);
        }

        // System.out.println("res: " + res + " ij: " +i+" "+j+ " val: "+matrix[i][j]);
        memo[i][j] = res;
        return res;
    }
}
