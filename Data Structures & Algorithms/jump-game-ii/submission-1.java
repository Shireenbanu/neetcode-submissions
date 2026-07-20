class Solution {
    public int jump(int[] nums) {
        int visited[] = new int[nums.length];
        Arrays.fill(visited, -1);
        return recurJump(nums, 0, visited);
    }

    public int recurJump(int[] nums, int runningIndex, int[] visited) {
        int res = Integer.MAX_VALUE;

        if (runningIndex >= nums.length) {
            return -1;
        }

        // System.out.println("runningIndex: " + runningIndex);

        if ((nums.length - 1) == runningIndex) {
            return 0;
        }

        if (nums[runningIndex] == 0 && runningIndex != (nums.length - 1)) {
            return -1;
        }

        if (visited[runningIndex] != -1) {
            return visited[runningIndex];
        }

        int possibleJs = 1;

        while ((possibleJs) <= nums[runningIndex] && (possibleJs + runningIndex < nums.length)) {
            int res2 = recurJump(nums, (possibleJs + runningIndex), visited);

            if (res2 >= 0) {
                res = Math.min(res2 + 1, res);
            }
            possibleJs++;
        }

        if (res == Integer.MAX_VALUE) {
            return -1;
        }

        visited[runningIndex] = res;
        System.out.println("for inde: " + runningIndex + " res: " + res);

        return res;
    }
}
