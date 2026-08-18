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
                if(c == ')'){
                    if(top == '('){
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if( c == '}'){
                    if(top == '{'){
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if(c == ']') {
                    if(top == '['){
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        return stack.size() == 0;

    }
}
