class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int num : asteroids){
            if(stack.isEmpty()){
                stack.push(num);
            } else {
                boolean isDestroyed = false;
                while(!stack.isEmpty() && stack.peek() > 0 && num < 0){
                    if(stack.peek() == num * -1){
                        stack.pop();
                        isDestroyed = true;
                        break;
                    } else if(stack.peek() < num * -1){
                        stack.pop();
                    } else {
                        isDestroyed = true;
                        break;
                    }
                }
                if(!isDestroyed) stack.push(num);
            }
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < stack.size(); i++){
            res[i] = stack.get(i);
        }
        return res;
    }
}

// 18:25

// if both go in same direction they don't colloide
// if both go in opposite - they collide smaller one gets removed - if + and - collide they destroy
    // if it is -ve and +ve they don't as they are going away from each other 