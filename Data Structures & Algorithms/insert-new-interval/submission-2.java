class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // first add everything greater to the new interval
        List<int[]> list = new ArrayList<>();
        int i = 0;
        for (i = 0; i < intervals.length; i++) {
            if (intervals[i][1] >= newInterval[0]) {
                break;
            }
            list.add(intervals[i]);
        }
// System.out.println("List; "+list);

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        list.add(newInterval);
        while(i<intervals.length){
            list.add(intervals[i]);
            i++;
        }

        int res[][] = new int[list.size()][2];
        
        int j =0;
        for(int[] items : list){
            res[j] = items;
            j++;
        }

        return res;
    }
}
