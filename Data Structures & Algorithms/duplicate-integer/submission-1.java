class Solution {
    public boolean hasDuplicate(int[] nums) {
        boolean flag = false;
        Arrays.sort(nums);

        if(nums.length <= 1 ){
            return false;
        }



      int prev = nums[0];
      for( int i=1; i<nums.length; i++){

        if(prev == nums[i]){
            flag = true;
            break;
        }
        else
        {
            prev = nums[i];
        }

      }  

      return flag;
    }
}