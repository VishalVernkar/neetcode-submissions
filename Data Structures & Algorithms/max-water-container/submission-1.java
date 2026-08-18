class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxArea = 0;
        while(l < r){
            maxArea = Math.max(maxArea, Math.min(heights[l], heights[r]) * (r - l));
            if(heights[l] <= heights[r]){
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}

// container with most water
// brute force - O(n^2)
// calculate area between each heights and record max

// Hint: two pointers
// more water -> more distance -> more height
// water level -> depends on less height
// which pointer to update?
// smaller one or bigger one?
// smaller side as thier might be bigger height ahead and we can get more water