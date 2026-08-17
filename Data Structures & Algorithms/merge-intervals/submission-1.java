class Solution {
    public int[][] merge(int[][] intervals) {

        // First, I sort all the integers

        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while( i<intervals.length){

            if(list.size() == 0){
                list.add(intervals[i]);
            }
            else
            {
                int[] prevB = list.get(list.size()-1);
                
                if(prevB[1]>=intervals[i][0]){
                    prevB[1] = Math.max(intervals[i][1], prevB[1]);
                    list.set(list.size()-1, prevB);
                }
                else
                {
                    list.add(intervals[i]);
                }
                
            }
            i++;
        }

        int res[][] = new int[list.size()][2];
        int j =0;
        for(int[] item: list)
            {res[j] = item; j++;}

    return res;
    }
}
