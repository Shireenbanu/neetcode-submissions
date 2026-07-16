class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int visited[][] = new int[nums.length][nums.length];
        for (int row[] : visited) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(encoreLenghtOfLIS(nums, i, i, visited), max);
        }
        return max;
    }

    public int encoreLenghtOfLIS(int[] nums, int prev, int runningIndex, int[][] visited) {
        int res1 = 0;
        
        if (runningIndex >= nums.length) {
            return 0;
        }

        if (visited[runningIndex][prev] != -1) {
            return visited[runningIndex][prev];
        }

        if (prev == runningIndex || nums[prev] < nums[runningIndex]) {
            res1 = 1 + encoreLenghtOfLIS(nums, runningIndex, runningIndex + 1, visited);
        }

        int res3 = encoreLenghtOfLIS(nums, prev, runningIndex + 1, visited);

        // System.out.println(
        // "max: " + Math.max(res3, res1) + " runningIndex: " + runningIndex + " prev = " + prev);

        visited[runningIndex][prev] = Math.max(res3, res1);

        return Math.max(res3, res1);
    }
}
