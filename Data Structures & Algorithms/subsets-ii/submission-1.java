class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        encore(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public List<List<Integer>> encore(
        int nums[], int runningIndex, List<Integer> list, List<List<Integer>> res) {
        // System.out.println("list: "+ list);

        List<Integer> list1 = new ArrayList<>(list);
        res.add(list1);

        if (runningIndex < nums.length) {
            for (int i = runningIndex; i < nums.length; i++) {
                if (i > runningIndex && nums[i] == nums[i-1]) {
                    continue;
                }

                list.add(nums[i]);
                encore(nums, i + 1, list, res);
                list.remove(list.size() - 1);
            }
        }

        return res;
    }
}
