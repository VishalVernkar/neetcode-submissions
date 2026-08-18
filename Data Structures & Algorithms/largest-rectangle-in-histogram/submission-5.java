class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        for(int i=0; i <= n; i++){
            while(!stack.isEmpty() && (i==n || heights[stack.peek()] > heights[i])){
                int curHeight = heights[stack.pop()];
                int leftIdx = (stack.isEmpty())? -1 : stack.peek();
                int width = i - leftIdx - 1;
                maxArea = Math.max(maxArea, curHeight * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}

// 10:50 - 11:10

// largest area
// depends 
// on min among heights
// consecutive heights
// 

// brute force
// from each heght calculate the area for all the next hieghts
// record max
// 

// here - 
