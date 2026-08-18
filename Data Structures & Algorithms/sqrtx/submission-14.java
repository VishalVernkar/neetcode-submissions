class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x;
        int res = 0;
        while(l <= r){
            int m = l + (r - l) / 2;
            long sqre = (long) m * m;
            if(sqre <= x){
                res = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}

// search for num where res <= x