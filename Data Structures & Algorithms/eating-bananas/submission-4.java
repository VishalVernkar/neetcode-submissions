class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i = 0; i < piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        int l = 1, r = max;
        while(l < r){
            int m = l + (r - l) / 2;
            if(getHours(piles, m) <= h){
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private int getHours(int[] piles, int rate){
        int tHrs = 0;
        for(int pile : piles){
            tHrs += (pile + rate - 1) / rate;
        }
        return tHrs;
    }
}

// find the eating rate
// <= target
// 10 
// 
// how the hours linked to piles

// 1 - 9 
// if I choose one hour how many hour it will take to finish the banas

// find <=