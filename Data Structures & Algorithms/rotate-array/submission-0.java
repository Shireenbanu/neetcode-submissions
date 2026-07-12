class Solution {
    public void rotate(int[] nums, int k) {

       int rotate  = (k%nums.length);
       System.out.println("rotate: "+rotate);

        int low =0;
        int high = nums.length -1;

        reverse( low,  high,  nums);
        // while(low<=high){
        //     int swap = nums[low];
        //     nums[low] = nums[high];
        //     nums[high] = swap;
        //     low++;
        //     high--;
        // }

        low = 0;
        high = rotate-1;
        reverse(low, high,nums);
        // while(low<=high){
        //     int swap = nums[low];
        //     nums[low]=nums[high];
        //     nums[high] = swap;
        //     low++;
        //     high--;
        // }
        low =rotate;
        high=nums.length-1;
        reverse(low, high, nums);

        // while(low<=high){
        //     int swap = nums[low];
        //     nums[low]=nums[high];
        //     nums[high] = swap;
        //     low++;
        //     high--;
        // }
       
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