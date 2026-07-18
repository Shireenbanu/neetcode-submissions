class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsetsEncore(nums, 0, res, new ArrayList<>());
        return res;
    }

    public void subsetsEncore(int nums[], int runningIndex, List<List<Integer>> res, List<Integer> list ){

        // System.out.println("List: "+ list);
        res.add(new ArrayList<>(list));

        if(runningIndex == nums.length){
            return ;
        }

        for(int i=runningIndex; i<nums.length; i++)
        {
            list.add(nums[i]);
            subsetsEncore(nums, i+1, res, list);
            list.remove(list.size()-1);
        }
    }
}
