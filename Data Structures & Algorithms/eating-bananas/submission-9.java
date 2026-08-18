class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int pile : piles){
            max = Math.max(max, pile);
        }

        int l = 1;
        int r = max;

        while(l < r){
            int m = l + (r - l)/2;
            if(time(piles, m) > h){
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }

    private int time(int[] piles, int rate){
        int totalTime = 0;
        for(int pile : piles){
            totalTime += (pile + rate - 1) / rate;
        }
        return totalTime;
    }
}

// return rate
// rate is inversly proportional to time - r ~ 1/t
// rate - min - total
// 

// to complete the pile I need to take the ceil
// 