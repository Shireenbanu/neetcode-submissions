class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        // System.out.println(Arrays.toString(queue.poll()));

        int directions[][] = new int[][] {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        while ((q.size()) != 0) {
            int ele[] = q.poll();
            int m = ele[0];
            int n = ele[1];
            // System.out.println("Entering: m: " + m + " n: " + n);

            for (int[] dir : directions) {
                // System.out.println(dir[0] + " " + dir[1]);
                int nM = m + dir[0];
                int nN = n + dir[1];

                if (nM < 0 || nM >= grid.length || nN < 0 || nN >= grid[0].length || grid[nM][nN] != Integer.MAX_VALUE) {
                        // System.out.println("continues; " + nM + " " + nN);
                        continue;
                }
                grid[nM][nN] = grid[m][n]+1; 
                // System.out.println("Neighbour: " + nM+ " " + nN);
                q.offer(new int[] {nM, nN});
            }

        }
    }
}
