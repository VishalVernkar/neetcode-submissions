class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int maxArea = 0;
        while(l < r){
            maxArea = Math.max(maxArea, Math.min(heights[l], heights[r]) * (r - l));
            if(heights[l] < heights[r]){
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}

// 16:19

// the water is max when - the distance between is heights is more and heights is more
// so we move from left and right
// we move smaller side -> becuase it we need larger side for large volume

// if both are equal we move -> any side -> why?
// it can be either small or big the next one

// if they both are big any side is fine - as it'll move to bigger side
// if both are small it is fine - as we have current big one
// if one samall and on big - it would still be smaller than the current one because of smalle height - so it'll work
