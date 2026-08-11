class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int res[] = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            int days = getNextBiggerNumber(i, stack, temperatures);
            // System.out.println("days: " + days);
            res[i] = days;
            stack.push(i);
        }

        return res;
    }

    public int getNextBiggerNumber(int ele, Deque<Integer> stack, int[] nums)  {
        int res = 0;
        
        while(stack.size()>0){
          
            if(nums[ele]<nums[stack.peek()]){
                // System.out.println("found : ");
                res = stack.peek() - ele;
                break;
            }
            else
            {
                stack.pop();
            } 

        }
        // System.out.println("ele: "+ ele+ " val: "+ val);
        
        return res;
    }
}
