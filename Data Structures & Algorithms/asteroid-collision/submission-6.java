class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid : asteroids){
            if(stack.isEmpty()){
                stack.push(asteroid);
            } else {
                int topAsteroid = stack.peek();
                asteroid(stack, topAsteroid, asteroid);
            }
        }
        return stack.stream()
                   .mapToInt(Integer::intValue)
                   .toArray();

    }

    private boolean isOppDirection(int a, int b){
        return (a > 0 && b < 0);
    }

    private void asteroid(Stack<Integer> stack, int topAsteroid, int asteroid){
       if(!isOppDirection(topAsteroid, asteroid)){
            stack.push(asteroid);
        } else {
            if(Math.abs(topAsteroid) == Math.abs(asteroid)){
                stack.pop();
            } else if(Math.abs(topAsteroid) > Math.abs(asteroid)){
                return;
            } else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(asteroid);
                } else {
                    asteroid(stack, stack.peek(), asteroid);
                }
            }
        }
    }
}
// 10:10 - 10:30

// direction

// opposite
// - +

// collides 
// if top > asteroid, no need to push it
// if asteroid > top, pop top -> keep checking same for other top of elements
// if same speed, pop top

// same
// - -
// + +

// never collide so push