class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for(int i =0; i<heights.length; i++){
          int runningIndex = i;
          int left  = checkForLeft(heights, runningIndex);
          int right = checkForRight(heights, runningIndex);
        //   System.out.println("left: "+ left + " right: "+right+ " i = "+ i +" res: "+ ((left+right+1)*heights[i]) );
          max = Math.max(max, ((left+right+1)*heights[i]) );
        }
        return max;
    }

    public int checkForLeft( int nums[], int runningIndex ){
       int j = runningIndex+1;
       int counter =0;
       while(j<nums.length && nums[j]>=nums[runningIndex]){
        counter++;
        j++;
       }
        return counter;
    }


    public int checkForRight( int nums[], int runningIndex ){
       int j = runningIndex-1;
       int counter =0;
       while(j>=0 && nums[j]>=nums[runningIndex]){
        counter++;
        j--;
       }
        return counter;
    }
}
