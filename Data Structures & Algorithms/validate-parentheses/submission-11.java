class Solution {
    public boolean isValid(String s) {
        if(s.length()%2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '[' || c == '(' || c == '{'){
                stack.push(c);
            } else if(!stack.isEmpty()){
                char top = stack.peek();
                if(top + 1 == c || top + 2 == c){
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        return (stack.isEmpty())? true : false;
    }
}

// 16:35

// 
