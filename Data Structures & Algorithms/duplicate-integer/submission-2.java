class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> h = new HashSet<Integer>();
        boolean flag = false;
        for(int i =0; i<nums.length ;i++){

            if(h.contains(nums[i])){
                flag = true;
                break;
            }

            h.add(nums[i]);
        }

        return flag;
    }
}