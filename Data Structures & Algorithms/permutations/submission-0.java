class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean visited[] = new boolean[nums.length];
        encoreList(nums, 0, res, new ArrayList<>(), visited);
        return res;
    }

    public void encoreList(int nums[], int runningIndex, List<List<Integer>> res,
        List<Integer> list, boolean visited[]) {
        // System.out.println(list);

        if (nums.length == list.size()) {
            res.add(new ArrayList<>(list));
        }

        if (list.size() > nums.length) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] != true) {
                list.add(nums[i]);
                visited[i] = true;
                encoreList(nums, i + 1, res, list, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
