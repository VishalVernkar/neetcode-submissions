class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
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

// 10:45 // 11:15
// Question
// [30,38,30,36,35,40,28]
//  0  1  2  3  4  5  6

// push only if low temperature -> push index
// 30 - push - 30
// 38 - pop 30 0 - stack 38 -> 1 - 0 => 1 
// 30 - push 30 2 - stack 38 30
// 36 - pop 30 2 - stack 38 36 -> 3 - 2 => 1
// 35 - push 35 4 - stack 38 36 35
// 40 - pop 35 4 - 5 - 4 => 1
//      pop 36 3 - 5 - 3 => 2
//      pop 38 1 - 5 - 1 => 4
//      push 40 5
// 28   push 28 6

// pop 28 6 => 0
// pop 40 5 => 0

