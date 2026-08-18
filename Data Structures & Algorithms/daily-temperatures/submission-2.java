class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            res[stack.pop()] = 0;
        }
        return res;
    }
}

// 22:32

//
// using stack 
// we push the index to the stack
// we pop all the smaller ones when we are pushing a big one
// as we pop - we update it's index with current day 