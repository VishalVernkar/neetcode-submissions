class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        StringBuilder cur = new StringBuilder();
        int num = 0;
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                num = num * 10 + (c-'0');
            } else if(c == '['){
                stack.push(cur);
                numStack.push(num);
                cur = new StringBuilder();
                num = 0;
            } else if (c == ']'){
                StringBuilder prev = stack.pop();
                int times = numStack.pop();
                while(times-- > 0){
                    prev.append(cur);
                }
                cur = prev; 
            } else {
                cur.append(c);
            }
        }
        return cur.toString();
        
    }
}

// using 2 stack
// one to track number and another to track string