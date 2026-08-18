class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int n = heights.length;
        int maxArea = 0;
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


// we need only heights in expanding manner to increse the area
// if we encounter smaller rectangle - we clear the existing bigger ones - calculate thier areas
// to calculate thier areas - we take width from current index to the index right behind it
// 