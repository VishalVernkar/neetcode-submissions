class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int res = 0;
        while(l <= r){
            int m = l + (r - l) / 2;
            if((long) m * m == x) return m;
            if((long) m * m < x) {
                res = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}