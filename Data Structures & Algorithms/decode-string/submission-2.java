class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int n = s.length();

        for(int i = n-1; i>=0 ; i--){
            char c = s.charAt(i);
            if(c == '['){
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && !stack.peek().equals("]")){
                    sb.append(stack.pop());
                }
                System.out.println(sb);
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
                //return String.join("", stack);


                stack.push(sbDecoded.toString());

            } else {
                stack.push(String.valueOf(c));
            }
        }

        //return String.join("", stack);
        String res = "";
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
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