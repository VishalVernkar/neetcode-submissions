class Solution {
    public int trap(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        while(l<r){
            if(leftMax < rightMax){
                // we get the next height by as we are going to calculate water height at this point 
                // consider the leftMax as boundary
                l++;
                // we increment early because if the height at this point is bigger than left max 
                // we get zero as max and current height are same
                // otherwise, we get negative if we don't make this update - which is extra
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }
}


// May be I can try similar approach with last one 
// two pointer approach

// brute force
// for each
// we need left and right boundary
// how will I determine the boundary?
// at a given height?
// its left or right boundary can be a block or empty
// if its a block we get it as boundary 
// if it is empty, what would be its boundary
//   I have to move to right till I find its height <= left boundary

// we have left and right pointer
// we move lesser side -> 
// we calculate water height at each height?
// 

// what am i not claer about?
// determining the boundary
// when will I decide to calulate the height of water
// 

//  for a given hieght,
//  height of water = min(max left height, max right height) - current height

// calculate for each height
// array - max from left
// array - max from right
// calulate height of water for each index - add only if positive

// water height depends on min (left max, right max)
// we use two pointers
// we initialze boundary as max values
// based on thier comparison, if leftmax is small we compute on left side and move
// or vice versa