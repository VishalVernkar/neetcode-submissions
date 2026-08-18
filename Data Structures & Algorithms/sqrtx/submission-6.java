class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int res = 0;
        while(l <= r){
            int mid = l + (r -l)/2;
            if((long)mid * mid <= x){
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // System.out.println(l);
        return res ;
    }
    // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
    // 0 1
}




