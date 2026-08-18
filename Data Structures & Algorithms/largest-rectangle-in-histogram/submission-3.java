class Solution {
    public int largestRectangleArea(int[] heights) {
        
		Stack<int[]> st = new Stack<int[]>();
		int maxArea = 0;
		
		for(int i=0;i<heights.length;i++) {
			int index = i;
			while(!st.isEmpty() && st.peek()[1]>=heights[i]) {
				index = st.peek()[0];
				maxArea = Math.max(maxArea, st.peek()[1]*(i - st.peek()[0]));
				st.pop();
			}
			st.push(new int[] {index,heights[i]});
		}
		
		while(!st.isEmpty()) {
			maxArea = Math.max(maxArea, st.peek()[1]*(heights.length - st.peek()[0]));
			st.pop();
		}
		
		return maxArea;
	
    }
}
