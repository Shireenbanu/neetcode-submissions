/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        int i1 = 0;
        // for (Interval row : intervals) {
        //     System.out.println(" row: " + row.start + " " + row.end + " i = "+ i1);
        //     i1++;
        // }
        int rooms = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < intervals.size(); i++) {
            if (!set.contains(i)) {
                rooms++;
                int j = i + 1;
                Interval lastInterval = intervals.get(i);
                while (j < intervals.size()) {
                    // if( i == 1){
                    //     System.out.println(" for i = "+ lastInterval.end + " j = "+
                    //     intervals.get(j).start);
                    // }
                    if (lastInterval.end <= intervals.get(j).start && !set.contains(j)) {
                        set.add(j);
                        lastInterval = intervals.get(j);
                    }
                    j++;
                }

                // System.out.println("i = " + i + " set: " + set);
            }
        }

        return rooms;
    }
}
