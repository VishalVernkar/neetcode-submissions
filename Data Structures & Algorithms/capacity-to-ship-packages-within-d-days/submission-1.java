class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE, sum = 0;
        for(int w : weights) {
            max = Math.max(w, max);
            sum += w;
        }
        int res = sum;

        int l = max, r = sum;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(canBeShipped(weights, days, m)){
                res = Math.min(res, m);
                r = m - 1;
            }
            else{
                l = m + 1;
            }
        }
        return res;
    }

    private boolean canBeShipped(int[] weights, int days, int cap) {
        int currentCap = cap, day = 1;

        for(int w : weights) {
            if(currentCap - w < 0) {
                day++;
                if(day > days){
                    return false;
                }
                currentCap = cap;
            }
            currentCap -= w;
        }
        return true;
    }
}