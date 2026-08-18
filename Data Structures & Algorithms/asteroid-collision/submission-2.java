// Example 1:

// Input: asteroids = [5,10,-5]
// Output: [5,10]
// Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
// Example 2:

// Input: asteroids = [8,-8]
// Output: []
// Explanation: The 8 and -8 collide exploding each other.
// Example 3:

// Input: asteroids = [10,2,-5]
// Output: [10]
// Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
// Example 4:

// Input: asteroids = [3,5,-6,2,-1,4]​​​​​​​
// Output: [-6,2,4]
// Explanation: The asteroid -6 makes the asteroid 3 and 5 explode, and then continues going left. On the other side, the asteroid 2 makes the asteroid -1 explode and then continues going right, without reaching asteroid 4.

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int n=asteroids.length;
        for(int i=0;i<n;i++){
            if(stack.isEmpty()){
                stack.push(asteroids[i]);
            } else if(asteroids[i] < 0 && stack.peek() > 0){
                // while top value is positive and grater less than the  -ve one pop it
                 // how to do this 
                // if 
                int diff = 0;
                while(!stack.isEmpty() && stack.peek() > 0){
                    diff = stack.peek() + asteroids[i];
                    if(diff == 0){
                        stack.pop();
                        break;
                    } else if(diff < 0) {
                        stack.pop();
                        // if(stack.isEmpty()) {
                        //     stack.push(asteroids[i]);
                        //     break;
                        // }
                    } else if(diff > 0) {
                        break;
                    }
                }
                if(diff < 0){
                    stack.push(asteroids[i]);
                }
            } else {
                stack.push(asteroids[i]);
            }
        }
        int[] res = stack.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }
}