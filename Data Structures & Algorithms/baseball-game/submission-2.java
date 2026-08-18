class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String str : operations){
            if(str.equals("+")){
                int a = stack.pop();
                int b = stack.peek();
                stack.push(a);
                stack.push(a + b);
            } else if(str.equals("D")){
                stack.push(stack.peek() * 2);
            } else if(str.equals("C")){
                stack.pop();
            } else {
                stack.push(Integer.parseInt(str));
            }
        }

        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}

// 16:24

// 

