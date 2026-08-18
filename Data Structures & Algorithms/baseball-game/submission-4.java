class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String oprn : operations){
            if(oprn.equals("+")){
                int a = stack.pop();
                int b = stack.peek();
                stack.push(a);
                stack.push(a + b);
            } else if(oprn.equals("D")){
                stack.push(2 * stack.peek());
            } else if(oprn.equals("C")){
                stack.pop();
            } else {
                stack.push(Integer.parseInt(oprn));
            }
        }
        int res = 0;
        while(!stack.isEmpty()) res += stack.pop();

        return res; 
    }
}