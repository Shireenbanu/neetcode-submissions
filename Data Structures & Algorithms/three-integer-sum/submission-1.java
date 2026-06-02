class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> arrList = new ArrayList<>();
        Set<String> hashSet = new HashSet<>();
       Arrays.sort(nums);
       System.out.println("arr: "+Arrays.toString(nums));
       for( int i=0; i<nums.length; i++){
        
        int target = nums[i]*-1;
        int low =i+1;
        int high = nums.length -1;
        // System.out.println("for item 1: "+ nums[i]);

        while(low<high){
            
            int sum = (nums[low]+nums[high]);
            if(sum == target && low!=i && high !=i){
                // System.out.println("found ans: "+nums[low]+" "+nums[high] + " = "+ sum );
                List<Integer> arr = new ArrayList<>(Arrays.asList(nums[i], nums[low], nums[high]));
                Collections.sort(arr);
                // System.out.println("arr: "+(arr.toString()));
            
                if(!hashSet.contains(arr.toString())){
                    hashSet.add(arr.toString());
                    arrList.add(arr);
                }
                low++;
                high--;
            }
            else if(sum<target){
              low++;
            }
            else{
                high--;
            }   
        }
        
       }
       return arrList;
    }
}
