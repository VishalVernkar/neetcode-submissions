class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n=s.length();
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else {
                if(stack.size() == 0) return false;
                char top = stack.peek();
                if(c == ')' && top == '('){
                    stack.pop();
                } else if( c == '}' && top == '{'){
                    stack.pop();
                } else if(c == ']' && top == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.size() == 0;

    }
}
