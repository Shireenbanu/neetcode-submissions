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
    public boolean canAttendMeetings(List<Interval> list) {
        boolean flag = true;
        int lastA = 0;
        int lastB = 0;
        Collections.sort(list, (a,b)->Integer.compare(a.start, b.start));
        for(Interval item: list){
            System.out.println(item.start+  " "+item.end);
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                lastA = list.get(i).start;
                lastB = list.get(i).end;
            } else {
                int temp = i;
                while (temp < list.size()) {
                    if (lastB > list.get(temp).start) {
                        flag = false;
                        break;
                    }
                    temp++;
                }
            }
            lastA = list.get(i).start;
            lastB = list.get(i).end;
        }

        return flag;
    }
}