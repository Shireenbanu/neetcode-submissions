class Solution {
    public boolean canPartition(int[] nums) {
        
        int target = 0;

        for(int item : nums){
            target+=item;
        }

        

        if(target %2 !=0){
            return false;
        }
        target = (target/2);

        boolean flag = canRecurPartition(nums, target, 0);

        return flag;
    }

    public boolean canRecurPartition(int nums[], int target, int runningIndex){
        boolean flag = false;
        // System.out.println(" runningIndex: "+ runningIndex + " target: "+ target);
        if(target == 0){
            return true;
        }

        if(target <0){
            return false;
        }

        if(runningIndex>nums.length){
            return false;
        }

        for(int i =runningIndex; i<nums.length; i++){
           flag =  canRecurPartition(nums, target - nums[i], i+1);
          if(flag){
            break;
          }
        }

        return flag;



    }
}
