class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for(int pile:piles){
            r = Math.max(pile, r);
        }

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
        int hrs = 0;
        for(int pile : piles) hrs += (pile + rate - 1) / rate;
        return hrs;
    }
}


// fin the rate at wihc the monkeys shoul eat bbanans to complete all in the h hours
// time => 1/rate -> inversly protional
// find rate <=