class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;

        for(int weight : weights){
            l = Math.max(l, weight);
            r += weight;
        }

        int res = r;
        while(l <= r){
            int m = l + (r - l) / 2;

            if(time(weights, m) <= days){
                res = m;
                r = m - 1; 
            } else {
                l = m + 1;
            }
        }

        return res;
    }

    private int time(int[] weights, int capacity){
        int cur = capacity;
        int days = 1;
        for(int weight : weights){
            if(cur < weight){
                days++;
                cur = capacity;
            } 
            cur -= weight;
        }
        return days;
    }
}

// min = max of weights
// max = total

// weights ~ 1/time