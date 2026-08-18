class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;

        while(l < r){
            int mid = l + (r -l)/2;
            if((long)mid * mid >= x){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return ((long)l*l > x)? l - 1: l ;
    }
}




