class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;
        for(int weight : weights){
            l = Math.max(l, weight);
            r += weight;
        }

        while(l < r){
            int m = l + (r - l) / 2;
            if(getDays(weights, m) <= days){
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private int getDays(int[] weights, int capacity){
        int days = 1;
        int limit = capacity;
        for(int weight : weights){
            if(limit - weight < 0){
                days++;
                limit = capacity;
            }
            limit -= weight;
        }
        return days;
    }


}

// weight capacity per day
// range l = max of the array, r = total of the array 
// 