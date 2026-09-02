class Solution {
    public int maxArea(int[] heights) {
        int l = 0; int r = heights.length - 1;
        int area = 0;
        while(l < r){
            if(heights[l] < heights[r]){
                area = Math.max(area, (r - l) * heights[l]);
                l++;
            } else {
                area = Math.max(area, (r - l) * heights[r]);
                r--;
            }
        }
        return area;
    }
}

// bar with lowest height always reduces the the volume
// 
