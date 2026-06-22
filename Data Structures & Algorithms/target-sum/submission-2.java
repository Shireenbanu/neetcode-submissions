class Solution {
    public int findTargetSumWays(int[] nums, int target) {
      if(nums.length ==1 && nums[0] == target){
        return 1;
      }
      int res =  findTargetRecursive(nums, target,0, 0); 
       return res;
    }

    public int findTargetRecursive(int nums[], int target, int tempTotal, int runningIndex){
        // System.out.println(" target: "+ tempTotal + " runningIndex: "+ runningIndex);
        int max1 = 0;

        if(runningIndex>1 && (tempTotal == target )){
            // System.out.println("Found target: "+ tempTotal + " runningIndex: "+ runningIndex);
            max1++;
        }

        if(nums.length == 1 && (tempTotal == target ) ){
            max1++;
        }

        if(nums.length == runningIndex){
            return max1;
        }

      

         max1 = findTargetRecursive(nums, target, tempTotal+(nums[runningIndex]*1),runningIndex+1)+
        findTargetRecursive(nums, target, tempTotal+(nums[runningIndex]*(-1)), runningIndex+1);
        
        // System.out.println("max is: "+ max1);
        return max1;
    }
}
