class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        Set<Integer> set = new HashSet<>();
        int max = 0;
        if(nums.length == 0){
            return 0;
        }

        int prev = nums[0];
        for( int i=0; i<nums.length; i++){
         
         if(prev == nums[i] || (prev+1) == nums[i]){
            set.add(nums[i]);
         }
         else
         {
            set.clear();
            set.add(nums[i]);
         }
         prev = nums[i];
        //  System.out.println("Array: "+ set);
        max = Math.max(max, set.size());
        }
        return max;
    }
}
