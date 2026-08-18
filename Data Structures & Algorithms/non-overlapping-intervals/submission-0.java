class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int n = intervals.length;
        int prevEnd = intervals[0][1];
        for(int i = 1; i < n; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(start < prevEnd){
                res++;
            } else {
                prevEnd = end;
            }
        }
        return res;
    }
}

// overlapping 
// best to remove -> 
// big ones 
// chaining overlapping ones
// to make it easier for big ones to identify
// we sort by end
// becasue as we check the previous one if it is overlapping
// in normal sort big ones com earlier and we tend to remove next one -> else we need to check the min end one and keep it as last end - 
// but in end sort big ones come after small ones so we easily skip big ones

// 16:53 // 17:13

// I can sort and check for overlapping intervals

// possiblity,
// It has to be minimum number
// if the range is bigger and the next number of intervals are smaller but their number is big - then I have to choose to remove this big one

// whcih one to remove?
// the last one or current one?
// how to determine it?

// Let see in tme line

//         a        b    1 5
//                      e         f 6 9
//              c           d 4 7
// --------------------------------------------------------------------------------
// in this case best is to remove c d
// if I remove a b, c d also needs to be removed

//         a                        b
//                      e        f
//              c     d      
// --------------------------------------------------------------------------------
// in this case best is to remove a b 
// if I remove a b, c d also needs to be removed


// see how many are overlapping?
// and choose best one?

// at the end I have to remove big range - that has many sub ranges
// should I look for chaining?

// I should remove bigger overlapping ranges
// I should remove chaining ones