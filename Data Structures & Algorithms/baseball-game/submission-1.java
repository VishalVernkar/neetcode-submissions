class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String operation: operations){
            switch(operation){
                case "+":
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    int num3 = num1 + num2;
                    stack.push(num1);
                    stack.push(num2);
                    stack.push(num3);
                    break;
                    
                case "D":
                    stack.push(stack.peek() * 2);
                    break;

                case "C":
                    stack.pop();
                    break;

                default :
                    stack.push(Integer.parseInt(operation));
                    break;

            }
        }

        int sum = 0;
        while(!stack.isEmpty()){
            sum +=stack.pop();
        }
        return sum;
        
    }
}