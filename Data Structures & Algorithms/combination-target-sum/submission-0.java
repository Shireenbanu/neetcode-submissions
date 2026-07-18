class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSumRecur(nums, target, 0, new ArrayList<>(), res);   
        return res;
    }

    public void combinationSumRecur(int[] nums, int target, int runningIndex,List<Integer> list, List<List<Integer>> res){
        // System.out.println("res: "+ list);
        if(target == 0){
            res.add(new ArrayList<>(list));
        }

        if(target<0){
            return;
        }

        for(int i = runningIndex; i<nums.length; i++){
            list.add(nums[i]);
            combinationSumRecur(nums, target-nums[i], i,list, res);
            list.remove(list.size()-1);
        }
    }
}
