class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int res = -1;

        // if (nums.length == 1) {
        //     if (nums[0] == target) {
        //         return 0;
        //     } else {
        //         return res;
        //     }
        // }

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                // System.out.println("found target: "+ mid);
                res = mid;
                break;
            } else if (nums[low] <= nums[mid]) {
                if (target >= nums[low] &&  target<=nums[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target >= nums[mid + 1] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            
        }
        return res;
    }
}
