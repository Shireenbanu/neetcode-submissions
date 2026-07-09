class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int visited[][] = new int[grid.length][grid[0].length];

        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, recursiveMaxArea(grid, i, j, visited));
            }
        }
        return max;
    }

    public int recursiveMaxArea(int[][] grid, int m, int n, int visited[][]) {
        int max = 0;
        if (m < 0 || m >= grid.length || n < 0 || n >= grid[0].length) {
            return 0;
        }

        if (grid[m][n] != 0 && visited[m][n] != 1) {
            visited[m][n] = 1;
            max = recursiveMaxArea(grid, m, n + 1, visited)
                + recursiveMaxArea(grid, m, n - 1, visited)
                + recursiveMaxArea(grid, m + 1, n, visited)
                + recursiveMaxArea(grid, m - 1, n, visited);
            max = max + 1;

            // System.out.println("Max : " + max + " m = " + m + " n = " + n);
        }
        return max;
    }
}
