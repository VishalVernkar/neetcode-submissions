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
        intervals.sort((a,b) -> a.start - b.start);
        int n = intervals.size();
        if(n == 0) return true;
        // int prevEnd = intervals.get(0).end;
        for(int i = 1; i < n; i++){
            Interval prevEnd = intervals.get(i - 1);
            Interval curr = intervals.get(i);
            if(curr.start < prevEnd.end){
                return false;
            } // else {
                // prevEnd = Math.max(prevEnd, curr.end);
            //}
        }
        return true;
    }
}
