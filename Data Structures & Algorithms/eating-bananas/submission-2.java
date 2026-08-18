class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for(int pile : piles){
            r = Math.max(r,pile);
        }
        while(l<r){
            int mid = l + (r - l)/2;
            if(canFinish(mid, piles, h)){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean canFinish(int speed, int[] piles, int h){
        int hoursConsumed = 0;
        for(int pile : piles){
            hoursConsumed += (pile + speed - 1)/speed; 
        }
        return hoursConsumed <= h;
    }
    // How do I know it is a binary search problem?
    // at what no of bananas per hour I can finish all the bananas in the given hours
    
    // 1 4 3 2 - 9
    // 10/9 - 2 - min or min - 1
    // worst case - for 1 hour - eat max number of bananas in array
    // b/w 2 - 4 find the right number - this is a range so binary search suits
}
