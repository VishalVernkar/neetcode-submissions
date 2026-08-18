// Example 1:

// Input: tokens = ["2","1","+","3","*"]
// Output: 9
// Explanation: ((2 + 1) * 3) = 9
// Example 2:

// Input: tokens = ["4","13","5","/","+"]
// Output: 6
// Explanation: (4 + (13 / 5)) = 6
// Example 3:

// Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
// Output: 22
// Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
// = ((10 * (6 / (12 * -11))) + 17) + 5
// = ((10 * (6 / -132)) + 17) + 5
// = ((10 * 0) + 17) + 5
// = (0 + 17) + 5
// = 17 + 5
// = 22
 
//
// I can push signs to a stack as I encounter them
// as I hit a number I pop the sign stack and use it with number
// next
// tokens are in strings
// my approach can give me sting at the end but how to conver it to math exp 

// I was wrong from biginning,
// I need to push numbers to stack and then once I encounter a operator we pop two elements and perfor operation

class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> nums = new Stack<>();
        int val = 0;
        for(int i=0; i<n ;i++){
            String s = tokens[i];
            if(s.equals("+")){
                val = nums.pop() + nums.pop();
                nums.push(val);
            } else if(s.equals("-")){
                int a = nums.pop();
                int b = nums.pop();
                val = b - a;
                nums.push(val);
            } else if(s.equals("/")){
                int a = nums.pop();
                int b = nums.pop();
                val = b / a;
                nums.push(val);
            } else if(s.equals("*")){
                val = nums.pop() * nums.pop();
                nums.push(val);
            } else {
                nums.push(Integer.parseInt(s));
            }
        }
        return nums.pop();
        
    }
}
