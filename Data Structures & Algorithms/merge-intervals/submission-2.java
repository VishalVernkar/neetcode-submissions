class Solution {
    public int[][] merge(int[][] intervals) {
        List<int []> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        res.add(intervals[0]);
        int n = intervals.length;
        for(int[] interval : intervals){
            int[] last = res.get(res.size()-1);
            if(last[1] >= interval[0]){
                last[1] = Math.max(last[1], interval[1]);
            } else {
                res.add(interval);
            }
        }

        return res.toArray(new int[0][]);
    }
}

// when we find a overlapping one
// we just update the end time of last one with current one
