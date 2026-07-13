class Solution {
    public int findDuplicate(int[] nums) {
        
        Arrays.sort(nums);
        // int prev = nums[0];
        for(int i=1; i<nums.length; i++){
            if((nums[i]) == nums[i-1]){
                // System.out.println((nums[i]-1) + " != "+nums[i-1]);
                return nums[i-1];
            }
        }


        return 0;
    }
}
