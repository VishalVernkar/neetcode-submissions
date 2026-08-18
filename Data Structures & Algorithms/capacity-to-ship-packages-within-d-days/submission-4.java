class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;
        for(int weight:weights){
            r+=weight;
            l = Math.max(l, weight);
        }
        while(l<r){
            int mid = l + (r - l)/2; // check if this weight capacity us suitable
            if(compare(mid, weights, days)){
                r = mid; // reduce weight capacity
            } else {
                l = mid + 1; // increase weight capacity
            }
        }
        return l;
    }

    private boolean compare(int capacity, int[] weights, int days){
        int load = 0;
        int consumedDays = 1; //why 1?
        for(int weight : weights){
            if(load + weight > capacity){
                consumedDays++;
                load = 0;
            } 
            load+=weight;
        }
        return consumedDays <= days; // why <= ?
    }


}

// In four days I have to ship all the weights in order
// In simple way
// weights = [2,4,6,1,3,10], days = 4
// 26/4 -> 7 weights per day min
// if 7 -> 2 4, 6 1, 3, 10-X -> not possible
// if 10 -> 2 4, 6 1 3, 10 -> possible

// min is max of array
// worst case I have to send everything in one day 
// so max = sum of array
// I have to choose between  min - max, this is a range so Binary search works
// 

// Rules
// Always read the question, even when I know it
// Approach through understanding question and finding the solution, even when I know the answer
    // This builds better understanding of question
    // better intuition - connecting understanding -> to intuition -> to approach 

// It is time to follow time
// set time to do things
// put effort on finishing them on time - I've got to push myself - It is possible - 
// not by stresssing my mind but by understanding - by taking simple steps - one step at a time -  - by making it easier 