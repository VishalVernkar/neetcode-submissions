class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        for(int i = 0; i < n; i++){
            if(stack.isEmpty()){
                stack.push(i);
            } else {
                int temp = temperatures[i];
                while(!stack.isEmpty() && temperatures[stack.peek()] < temp){
                    int idx = stack.pop();
                    temperatures[idx] = i - idx; 
                }
                stack.push(i);
            }
        }

        while(!stack.isEmpty()){
            temperatures[stack.pop()] = 0;
        }

        return temperatures;
    }
}

// we use stack 
// track indexex
// we push strictly devreasing temp in the stack 
// if we get a hot temp - we pop till it is bigger than top stack