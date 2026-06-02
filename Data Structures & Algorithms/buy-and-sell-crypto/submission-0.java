class Solution {
    public int maxProfit(int[] nums) {
        int buy = 0;
        int oldProfit = 0;
        int minPurchase = nums[0];
        int maxProfit = 0;
        for (int sell = 0; sell < nums.length; sell++) {
            int newProfit = 0;
            newProfit = nums[sell] - nums[buy];
            minPurchase = Math.min(minPurchase, nums[sell]);
            maxProfit = Math.max(maxProfit,Math.max((nums[sell] - minPurchase), newProfit));
            

            if (oldProfit >= newProfit) {
                buy = sell;
            }

            // System.out.println(
            //     "oldProfit: " + oldProfit + " newProfit: " + newProfit + " buy: " + nums[buy] + " maxProfit: "+maxProfit);
            // oldProfit = newProfit;

        }
        return maxProfit;
    }
}
