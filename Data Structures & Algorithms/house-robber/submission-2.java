class Solution {
    public int rob(int[] nums) {
        if(nums.length ==1){
            return nums[0];
        }

        int memo[] = new int[nums.length];
        Arrays.fill(memo,-1);
    //   you can have two starts:
      int res1 = encore(0, nums, memo);
      int res2 = encore(1, nums, memo);
       return Math.max(res1, res2);
    }

    public int encore(int i, int nums[], int[] memo){
        
        if(i >nums.length){
            return 0;
        }

        if(memo[i] != -1){
            return memo[i];
        }

        int max = 0;
        for(int j = i+2; j<nums.length; j++)
        {
           max = Math.max(max, encore(j, nums, memo)); 
        }

        memo[i] = nums[i]+ max;

        // System.out.println("max is: "+ max + " i = "+ i);

        return (nums[i]+max);
    }
}
