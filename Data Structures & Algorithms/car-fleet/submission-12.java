class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        int[][] cars = new int[n][2];
        for(int i=0; i<n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> a[0] -  b[0]); // ascending order
    
        Stack<Double> stack = new Stack<>();
        for(int i=0; i<n; i++){
           double currentCarTime = (double) (target - cars[i][0]) / cars[i][1];
           while(!stack.isEmpty() && currentCarTime >= stack.peek()){
                stack.pop();
           }
           stack.push(currentCarTime);
        }

        return stack.size();
        
    }
}

// 11:39

// sort the car based on position
// brute force
// start from min position car
// move each of them for one step
// see if any cars meet - add to fleet
// (n + n) * N


// Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1]
// 0 1 4 7
// 