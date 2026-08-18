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
        if (intervals.size() == 0) {
            return 0;
        }

        int res = 0;
        intervals.sort(Comparator.comparingInt(interval -> interval.start));


        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Interval item : intervals) {
            if (pq.size() == 0 || pq.peek() > item.start) {
                res++;
            } else {
                pq.poll();
            }
             pq.add(item.end);
        }

        return res;
    }

}
