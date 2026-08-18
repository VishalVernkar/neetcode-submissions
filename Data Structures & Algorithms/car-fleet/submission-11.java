class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        // if(n == 1) return 1;

        int[][] cars = new int[n][2];
        for(int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> a[0] - b[0]);
        // for(int[] val : cars){
        //     System.out.println(Arrays.toString(val));
        // }
        // System.out.println(Arrays.toString(cars));

        Deque<Double> stack = new ArrayDeque<>();

        for(int i = n - 1; i >= 0; i--){
            double cartime = (double) (target - cars[i][0]) / cars[i][1];
            System.out.println(cartime);
            System.out.println();
            if(!stack.isEmpty() && cartime <= stack.peek()){
                continue;
            } else {
                stack.push(cartime);
            }
            System.out.println(stack);
        }

        return stack.size();

    }
}

// 11:45 // 12:05
// so I need the cars in order based on position so
// first I woud create a 2 d array and sort them
// use stack to see whihc cars form fleet whcih car join fleet
// cars that go ahead of top of stack they join the fleet
// else they form a new fleet so we push it to the stack
