class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod [] = new int[nums.length];
        int res [] = new int[nums.length];

        for(int i=nums.length-1; i>=0;i--){
            if(i == nums.length-1){
                prod[i] = nums[i];
            }
            else
            {
                prod[i]=nums[i]*prod[i+1];
            }
        }

        int prev = 1;
        for( int i=0;i<nums.length; i++){
            if(i +1 == nums.length){
            res[i]= prev;
            }
            else{res[i]= prev*prod[i+1];}
            
            prev = prev*nums[i];
        }

        // System.out.println("Array: "+ Arrays.toString(res));

        return res;
    }
}  
