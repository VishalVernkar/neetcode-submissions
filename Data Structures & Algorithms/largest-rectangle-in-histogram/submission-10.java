class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0, n = heights.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= n; i++){
            while(!stack.isEmpty() && (i == n || heights[stack.peek()] > heights[i])){
                int height = heights[stack.pop()];
                int width = (stack.isEmpty())? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}

// push each height if it more than top of stack
// If I encounter a small - this will reduc the existing heights area 
// so pop each one till the current is small


