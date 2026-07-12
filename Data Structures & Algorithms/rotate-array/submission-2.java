class Solution {
    public void rotate(int[] nums, int k) {

        int rotate  = (k%nums.length);
        int low =0;
        int high = nums.length -1;
        reverse( low,  high,  nums);

        low = 0;
        high = rotate-1;
        reverse(low, high,nums);
 
        low =rotate;
        high=nums.length-1;
        reverse(low, high, nums);
       
    }

    public void reverse(int low, int high, int nums[]){
          
           while(low<=high){
            int swap = nums[low];
            nums[low] = nums[high];
            nums[high] = swap;
            low++;
            high--;
        }
    }
}