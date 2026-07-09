class Solution {
    public int maxSubArray(int[] nums) {
        
        int max = nums[0];
        int sum = nums[0];

        for(int i=1; i<nums.length; i++){

            int newSum =sum+nums[i];
            // System.out.println("newSum : "+ newSum+ " sum: "+ sum);
            if(newSum>nums[i]){
                sum = newSum;
            }
            else
            {
                sum = nums[i];
            }
            // System.out.println("After newSum : "+ newSum+ " sum: "+ sum);
            max = Math.max(max,sum);
        }
        return max;
    }
    
}
