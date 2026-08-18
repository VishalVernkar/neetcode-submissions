class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> numS = new Stack<>();

        int num = 0;
        StringBuilder cur = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c >= '0' && c <= '9'){
                num = num * 10 + (c - '0'); 
            } else if(c == '['){
                numS.push(num);
                stack.push(cur.toString());
                cur.setLength(0);
                num = 0;
            } else if(c == ']'){
                int count = numS.pop();
                StringBuilder prev = new StringBuilder(stack.pop());
                while(count > 0){
                    prev.append(cur);
                    count--;
                }
                cur = prev;
            } else {
                cur.append(c);
            }
        }

        return cur.toString();
    }
}

// using 2 stacks
// one for num and one for string
// num stack push - 2
// a - push a








// close - pop 
// b - close - pop b - repeat 3 times - push back - bbb
// a - 3
//   - 2