class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;

        int maxArea = 0;
        for(int i=0 ; i<=n; i++){
            while(!stack.isEmpty() && (i == n || heights[i] < heights[stack.peek()])){
                int height = heights[stack.pop()];
                int leftIdx = (stack.isEmpty())? -1 : stack.peek();
                int width = i - leftIdx - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}

// question
// Find the largest area rectangle
// what makes the largest area?
// considering the current bar as height, its area is max as long as it encounters smaller bar heights from left and right boundary 

// with the brute force
// n*n
// for each bar find it's left small bar and right small bar

// we can do it using stack
// how stack helps
// using monotonically increasing stack - helps to track smallest left boundary element and as we encounter small one from right we got both boundaries for elements in it.
// we push index to stack if new element is bigger.
// else we found the smaller right element, which is small right boundry - (we found the boundary that makes that makes the area small)
// then, we pop each bigger elements and calculate its area with left boundary being its prvious element in stack which is obiously smaller than popped element 

// 
// we pop because we found the small boundary
// we calculate from the popped becuase we know its left and right boundary 