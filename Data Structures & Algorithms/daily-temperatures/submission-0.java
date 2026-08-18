class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> temps = new Stack();
        int n=temperatures.length;
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            while(!temps.isEmpty() && temperatures[temps.peek()] < temperatures[i]){
                int idx = temps.pop();
                res[idx] = i - idx;
            }
            temps.push(i);
        }

        while(!temps.isEmpty()){
            res[temps.pop()] = 0; 
        }

        return res;
               
    }
}

        // I have to check warmer day than current day
        // Hint stack

        // brute force
        // n * n - check from current day till I find the warmer day then record its distance

        // push each number
        // if bigger number comes pop low ones and count it

        // 0,  1   2  3  4  5  6  7
        // [73,74,75,71,69,72,76,73]
        // pu - 73 
        // po - 73, pu 74 
        // res - 1, 1, 

        // [75, 71, 69, ]

        // I have to use index in stack when that index gets popped I update its distance from the current high temp index
        //    2    5     6
        // [75, 72, ] 76 
        // 6-2   6-5 

        // [76, 73]- // whatever left in stack i update thier index with zero

// Example 1:

// Input: temperatures = [73,74,75,71,69,72,76,73]
// Output: [1,1,4,2,1,1,0,0]
// Example 2:

// Input: temperatures = [30,40,50,60]
// Output: [1,1,1,0]
// Example 3:

// Input: temperatures = [30,60,90]
// Output: [1,1,0]