class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        Stack<int []> stack = new Stack<>();
        stack.push(intervals[0]);
        int n = intervals.length;
        for(int i = 1; i < n; i++){
            int[] last = stack.peek();
            if(last[1] >= intervals[i][0]){
                int start = Math.min(last[0], intervals[i][0]);
                int end = Math.max(last[1], intervals[i][1]);
                stack.pop();
                stack.push(new int[]{start, end});
            } else {
                stack.push(intervals[i]);
            }
        }
        int[][] res = stack.toArray(new int[0][]);
        return res;
    }
}

// Merge
// 15:40 - 16:00

// if it was sorted it'd be easy to compare to next ones
// now  is it possible to do it in O(n)

// I'll do it in O(n log n) first

// now the new interval got I have to make sure it is not overlapping with next ones
// so I have to update pointer
