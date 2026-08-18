class Solution {
    public int calPoints(String[] operations) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(String s : operations){
            if(s.equals("+")){
                int a = stack.pop();
                int b = stack.peek();
                stack.push(a);
                stack.push(a + b);
            } else if(s.equals("D")){
                stack.push(2 * stack.peek());
            } else if(s.equals("C")){
                stack.pop();
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        while(!stack.isEmpty()){
            res+=stack.pop();
        }

        return res;
    }
}