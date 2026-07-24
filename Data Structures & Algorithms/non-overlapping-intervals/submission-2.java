class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int counter = 0;
        int prev = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[prev][1] > intervals[i][0]) {
                // System.out.println("removing: " + prev + " i: " + i);
                if (intervals[prev][1] > intervals[i][1]) {
                    // System.out.println("prev[1] = " + intervals[prev][1]);
                    prev = i;
                }
                counter++;
            }
            else
            {
                prev = i;
            }
        }
        return counter;
    }
}
