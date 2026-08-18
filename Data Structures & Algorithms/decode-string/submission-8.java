class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        int n = s.length();

        for(int i = n-1; i>=0 ; i--){
            char c = s.charAt(i);
            if(c == '['){
                StringBuilder sb = new StringBuilder();
                System.out.println(stack);
                while(!stack.isEmpty() && stack.peek().charAt(0) != ']'){
                    sb.append(stack.pop());
                }
                stack.pop();
                i--; //skip [
                StringBuilder number = new StringBuilder();
                while(i>=0 &&  s.charAt(i) > 47 && s.charAt(i) < 58){
                    number.append(s.charAt(i));
                    i--;
                }
                i++;
                int num = Integer.parseInt(number.reverse().toString());
                
                StringBuilder sbDecoded = new StringBuilder();
                while(num > 0){
                    sbDecoded.append(sb);
                    num--;
                }
                stack.push(sbDecoded);

            } else {
                stack.push(new StringBuilder().append(c));
            }
        }

        //return String.join("", stack);
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.toString();
    }
}

// I'm trying to optimize, or perfect before trying approach - which is time consuming. i should try my apprach first then optimization

// mistakes
// stack pop gives reversed string - Itried reversing the string but the decoded string gets revrsed again

// I can read the string from end?
// then reverse the result at end

// StringBuilder number = new StringBuilder<>();
// if(c > 47 && c < 58)
// if(number.length() !=0) {
//                     stack.push(number.toString());
//                     number.setLength(0);
//                 }

// Brute force
// is complicated to think

// Stack
// we traverse each char
// we push everything
// once we find ']' 
// we pop till [, then we read numbers before it
// then create the string push it back to stack
// then append the final string

// can I optimize this
// use

// approach recursion is possible here.