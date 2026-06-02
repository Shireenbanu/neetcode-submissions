class Solution {
    public int maxArea(int[] heights) {
        
        int low = 0;
        int high = heights.length-1;
        int max = 0;

        while(low<=high){
            
            int val = Math.min(heights[low], heights[high]) * (high-low);
            max = Math.max(max, val);
            // System.out.println("low : "+ low + " high: "+high);
            // System.out.println("max is: "+max);
            if(heights[low]<=heights[high]){
                low++;
            }
            else{
                high--;
            }
        }
        return max;
    }
}
