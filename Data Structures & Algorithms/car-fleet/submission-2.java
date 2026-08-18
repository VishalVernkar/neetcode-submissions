class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        int[][] cars = new int[n][2];
        for(int i=0; i<n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> a[0] -  b[0]);
        
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

// Question
// I have to find the car fleets, 
// cars cannot cross, it'll follow next car speed it catches
// cars with low speed cannot catch high speed cars

// we can sort based on car speeds - ascending order
// we can compute time required to reach the target
// for each cars
// stack
// what will help me dtermine the pop
// increasing stack ? 
// decreasing stack ?
// we push time taken to reach the target if the next car is slower than top we pop the top of stack 

// target = 12
// position = [10,8,0,5,3]
// speed =    [02,4,1,1,3]
// 1) - 10 -> 12, 

// target = 100, 
// position = [0,2,4], 
// speed =    [4,2,1]
// 1) - 0 -> 4, 2 -> 4, 4 -> 5
// 2) - 0 -> 6, 2 -> 6, 4 -> 6 
// in step 1, 0 became fleet so it will go along with 2
// in step 2, 2 becomes fleet with 4 and end up with 1 fleet reaching target at 100

// How to solve this
// I have to get number of car fleets till the target is reached
// 
// I can see where the car fleets get formed by increment each of them with thier speed
// I can track the car fleet based on the lowest speed car in the fleet

// target = 12
// position = [10,8,0,5,3]
// speed =    [02,4,1,1,3]
// let fleets = 5

// 1)
// position = [12,12,1,6,6]
// speed =    [ 2, 4,1,1,1]
// fleets = 3

// 2)
// position = [2,7,7]
// speed =    [1,1,1]
// fleets = 3


// brute force - n * n
// - I have to increment speed 
// - check if any fleet formed
// - if true, 
//   if the target is reached, remove them, reduce the total fleet
//   else reduce total fleet and resset thier speeds to lowest one
// - do it until all of them reach the target
//


// Hint: stack
// How can implement it here
// based on the complexiety hint I can sort the speeds or pos?

// sort // // position = [10,8,0,5,3]
// position = [0,3,5,8,10]

