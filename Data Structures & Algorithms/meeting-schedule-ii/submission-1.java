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
        int count = 0;
        int n = intervals.size();
        int[] startIntervals = new int[n];
        int[] endIntervals = new int[n];
        for(int i = 0; i < n; i++){
            startIntervals[i] = intervals.get(i).start;
            endIntervals[i] = intervals.get(i).end;
        }

        Arrays.sort(startIntervals);
        Arrays.sort(endIntervals);

        int j = 0;
        for(int i = 0; i < n; i++){
            if(startIntervals[i] < endIntervals[j]){
                count++;
            } else {
                j++;
            }
        }
        return count;
    }
}
