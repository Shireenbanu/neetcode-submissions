class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // for (int items[] : intervals) System.out.println(Arrays.toString(items));
        List<Integer> items = new ArrayList<>();
        // if(intervals.length >0){
        //     items.add(0);
        // }
        int prev = 0;
        int remove = 0;
        for (int i = 1; i < intervals.length; i++) {
            if ((intervals[prev][1] > intervals[i][0])) {
                // System.out.println(" prev: " + prev + " i : " + i + " are overlapping");
                if (intervals[prev][1] >= intervals[i][1]) {
                    // System.out.println("Knock off: " + prev);
                    prev = i;
                    remove++;
                } else {
                    remove++;
                }

            } else {
                prev = i;
            }
        }

        return remove;
    }
}
