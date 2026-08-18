class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        int i = 0, n = s.length();
        int num = 0;
        StringBuilder cur = new StringBuilder();
        while(i < n){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                num = num * 10 + c - '0';
            } else if(c == '[') {
                numStack.push(num);
                stack.push(cur.toString());
                num = 0;
                cur.setLength(0);
            } else if(c == ']'){
                StringBuilder temp = cur;
                cur = new StringBuilder(stack.pop());
                int count = numStack.pop();
                while(count-- > 0){
                    cur.append(temp);
                }
            } else {
                cur.append(c);
            }
            i++;
        }
        return cur.toString();

    }
}