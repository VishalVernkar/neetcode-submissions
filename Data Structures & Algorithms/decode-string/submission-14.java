class Solution {
    public String decodeString(String s) {
        Stack<String> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        int i = 0, n = s.length();
        // StringBuilder sb = new StringBuilder();
        int num = 0;
        for(char c : s.toCharArray()){
            if(c >='0' && c <= '9'){
                num = num * 10 + (c - '0');
            }else if(c == '['){
                s1.push(Character.toString(c));
                s2.push(num);
                num = 0;
            } else if(c == ']') {
                StringBuilder sb = new StringBuilder();
                while(!s1.isEmpty() && !s1.peek().equals("[")){
                    sb.insert(0, s1.pop());
                }
                s1.pop();
                int count = s2.pop();
                StringBuilder sb2 = new StringBuilder();
                while(count > 0){
                    sb2.append(sb);
                    count--;
                }
                s1.push(sb2.toString());
            } else {
                s1.push(Character.toString(c));
            }
        }
        return String.join("",s1);
    }
}

// 12:50
//
// using 2 stack
// pnce to push the chunks and other to track numbers 