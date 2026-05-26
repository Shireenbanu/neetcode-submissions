class Solution {
    public int findMin(int[] nums) {
        
        int low = 0;
        int high = nums.length -1;
        int mid = 0;

        if(nums.length == 1){
            return nums[0];
        }

        while(low<high){
            mid = (low+high)/2;
            // System.out.println("mid = "+ mid);

            int firstRange = Math.min(nums[low], nums[mid]);
            int secondRange = Math.min(nums[mid+1], nums[high]);

            if(firstRange<secondRange){
                high = mid;
            }
            else
            {
                low = mid+1;
            }
            // System.out.println(" low = "+ low + " high = "+high);

            }
            // System.out.println(" nums[low] = "+ nums[low]);

        

        return nums[low];

    }
}
