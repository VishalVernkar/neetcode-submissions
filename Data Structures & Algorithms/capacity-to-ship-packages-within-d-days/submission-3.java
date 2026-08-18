class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int r = 0;
        int max = 0;
        for(int weight:weights){
            r+=weight;
            max = Math.max(max, weight);
        }

        int minWeight = (r + days - 1)/days;
        int l = Math.max(max,minWeight);

        while(l<r){
            int mid = l + (r - l)/2;
            if(compare(mid, weights, days)){ // weights -> 1/days
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l + " "+ r);
        return l;
        

    }

    private boolean compare(int k, int[] weights, int days){
        int chunk = 0;
        int consumedDays = 1;
        for(int weight:weights){
            if(chunk + weight <= k){
                chunk+=weight;
            } else {
                chunk = weight;
                consumedDays++;
            }
        }
        return consumedDays <= days;
    }
}

// In direct words
// divide the weights  in order to days
// get the max weight in that

// [2,4,6,1,3,10], days = 4
// 26/4 = 7
// 2 4
// 6 1
// 3
// 10 > 7

// min 10
// max 26
// 2 4
// 6 1 3
// 10


// brute force

//  [1,5,4,4,2,3], days = 3
//  19/3 = 7
//  6/3 = 2

//  min = 
//  max = 