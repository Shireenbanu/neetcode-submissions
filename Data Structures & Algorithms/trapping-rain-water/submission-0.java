class Solution {
    public int trap(int[] height) {
        int maxLeft[] = new int[height.length];
        int maxRight[] = new int[height.length];

        int max = 0;
        for(int i =0;i <maxLeft.length; i++){
            max = Math.max(max, height[i]);
            maxLeft[i] = max;
        }

        max = 0;
        for(int i =maxRight.length-1;i >=0; i--){
            max = Math.max(max, height[i]);
            maxRight[i] = max;
        }
        // System.out.println("Left: "+ Arrays.toString(maxLeft));

        // System.out.println("Right: "+ Arrays.toString(maxRight));

        
        int total =0;
        for(int i=0; i<height.length; i++){
            total = total+(Math.min(maxLeft[i],maxRight[i])-height[i]);
        }
        return total;
    }
}
