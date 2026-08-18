class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack();
        for(String operation : operations){
            switch (operation) {
                case "+":
                    stack.push(stack.peek() + stack.get(stack.size()-2));
                break;

                case "D":
                    stack.push(stack.peek() * 2);
                break;

                case "C":
                    stack.pop();
                break;

                default:
                    int val = Integer.valueOf(operation);
                    stack.push(val);
                break;
            }

        }
        int sum = 0;
        for(int num: stack){
            sum+=num;
        }
        return sum;
    }
}