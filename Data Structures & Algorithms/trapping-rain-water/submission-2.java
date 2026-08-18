class Solution {
    public int trap(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        int maxLeft = height[l], maxRight = height[r];
        while(l < r){
            if(maxLeft < maxRight){
                l++; // move to calcuate the current water height at l
                maxLeft = Math.max(maxLeft, height[l]);// update before, if we have a block at current height - no water is there - gets cancelled - be subtracting current height
                res += maxLeft - height[l];
            } else {
                r--;
                maxRight = Math.max(maxRight, height[r]);// update before, if we have a block at current height - no water is there - gets cancelled - be subtracting current height
                res += maxRight - height[r];
            }
        }
        return res;
    }
}

// 9:46

// rain water height at current point depends on -> min height of (maxleft, maxheight) boundary - current height
// we can pre compute 
// left max array
// right max array
// min(left, right) - current height 

// we can simplify this to O(n)
// by using to pointers
// moving towards the min max side - to calculate the current height of water
// we update height before the calculating cuurent becuse if current height is a block that no water can be stored 
// 
