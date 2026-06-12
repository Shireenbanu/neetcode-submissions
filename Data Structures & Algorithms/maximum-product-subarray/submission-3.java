class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int bigMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int maxVal = Math.max(max*nums[i], Math.max(nums[i], nums[i]*min));
            int minVal = Math.min(max*nums[i], Math.min(nums[i], nums[i]*min));
            max = maxVal;
            min = minVal;
            // System.out.println("Min: "+ min + " Max: "+ max);
            bigMax = Math.max(bigMax, max);
        }
        return bigMax;
    }
}
