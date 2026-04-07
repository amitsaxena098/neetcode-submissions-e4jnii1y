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
        if(intervals.isEmpty() || intervals.size() == 1) {
            return true;
        }
        PriorityQueue<Interval> pq = new PriorityQueue<>((first, second) -> {
            if(first.start != second.start) {
                return Integer.compare(first.start, second.start);
            }
            return Integer.compare(first.end, second.start);
        });

        for(Interval interval : intervals) {
            pq.offer(interval);
        }

        int prevEnd = pq.poll().end;
        while(!pq.isEmpty()) {
            Interval current = pq.poll();
            if(prevEnd <= current.start) {
                prevEnd = current.end;
            } else {
                return false;
            }
        }
        return true;


    }
}
