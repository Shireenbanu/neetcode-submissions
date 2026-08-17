
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
    public boolean canAttendMeetings(List<Interval> intervals) {
        boolean res = true;
        intervals.sort(Comparator.comparingInt(interval -> interval.start));

        // for (Interval item : intervals) {
        //     System.out.println("interval: " + item.start + " " + item.end);
        // }
        List<Interval> list = new ArrayList<>();

        for (Interval item : intervals) {
            if (list.size() == 0) {
                list.add(item);
            } else {
                Interval prev = list.get(list.size() - 1);
                if (prev.end > item.start) {
                    res = false;
                    break;
                } else {
                    list.add(item);
                }
            }
        }

        return res;
    }
}
