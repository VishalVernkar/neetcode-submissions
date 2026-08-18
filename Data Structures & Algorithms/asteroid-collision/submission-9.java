class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int stone : asteroids) {
            if (stack.isEmpty()) {
                stack.push(stone);
            } else {
                boolean isDestroyed = false;
                while (!stack.isEmpty() && stone < 0 && stack.peek() > 0) {
                    int res = stack.peek() + stone;
                    if (res == 0) {
                        isDestroyed = true;
                        stack.pop();
                        break;
                    } else if (res < 0) {
                        stack.pop();
                    } else {
                        isDestroyed = true;
                        break;
                    }
                }
                if (!isDestroyed)
                    stack.push(stone);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}