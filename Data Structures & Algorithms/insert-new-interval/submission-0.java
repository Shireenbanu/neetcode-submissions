class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<List<Integer>> list = new ArrayList<>();

        int i=0;
        while(i<intervals.length && intervals[i][1]<newInterval[0]){
            list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            i++;
        }

        while(i<intervals.length && (newInterval[1]>=intervals[i][0])){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(Arrays.asList(newInterval[0], newInterval[1]));

        while(i<intervals.length){
            list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            i++;
        }
        
        int res[][] = new int[list.size()][2];
        i=0;
        for(List<Integer> items: list){
            res[i][0] = items.get((int)0);
            res[i][1] = items.get((int)1);
            i++;
        }


        return res;
        
    }
}
