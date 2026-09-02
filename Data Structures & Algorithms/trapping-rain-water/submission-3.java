class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxLeft = height[l];
        int maxRight = height[r];
        int water = 0;
        while(l <= r){
            if(maxLeft < maxRight){
                maxLeft = Math.max(maxLeft, height[l]);
                water += maxLeft - height[l];
                l++;
            } else {
                maxRight = Math.max(maxRight, height[r]);
                water += maxRight - height[r];
                r--;
            }
        }

        return water;
    }
}

/// we have left and r boundry
// water collects upto the lower point boundry
// the height of water at current point depends on its max left boundry and max right boundry
// 


// brute force
// at each boint 
// get its
// left max boundrty and right max boundry
// height of water = min height - current height