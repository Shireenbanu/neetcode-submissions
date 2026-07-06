class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int res[] = new int[2];
        int low = 0;
        int high = numbers.length -1;

        while(low<high){

            int val = numbers[low]+numbers[high];

           if(val == target){
            break;
           }
           else if( val<target){
            low++;
           }
           else
           {
            high--;
           }
        }
        // System.out.println(" low: "+ low + " high: "+ high);
        res[0] = low+1;
        res[1] = high+1;
        return res;
    }
}
