class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x;
        while(l <= r){
            int m = l + (r - l) / 2;
            // long square = m * m;
            if((long) m * m == x){
                return m;
            }else if((long) m * m < x){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l - 1; 
    }
}

