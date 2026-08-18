class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int num : matchsticks){
            sum+=num;
        }

        if(sum%4 != 0) return false;

        int side = sum/4;

        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int[] sides = new int[4];

        return backtrack(matchsticks, 0, sides, side);
    }

    private boolean backtrack(int[] matchsticks, int idx, int[] sides, int target){
        if(idx == matchsticks.length) return true;

        int matchstick = matchsticks[idx];
        for(int i = 0; i < 4; i++){
            if(sides[i] + matchstick > target) continue;
            sides[i] += matchstick;
            if(backtrack(matchsticks, idx + 1, sides, target)) return true;
            sides[i] -= matchstick;
        }

        return false;
    }

    private void reverse(int[] nums){
        int l = 0;
        int r = nums.length - 1;

        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

}

// 6:55 - 7:15

//  Question
// I've an array of matchstick whose length are in index i 
// they can be different
// I must use all the match sticks
// and should be able to form a square 

// Intuition
// To form a square we need match sticks of equal length
// if it is not equal - no square
// get sum of all - if sum%4 == 0 -> true can be formed. else, false
// get the sum/4 side - this will be target
// we need to dvide array in such a way that all the 4 sides are equal

// steps
// this is a premuation problem
// place numbers in 4 places - in such a way that thier sum is equal
// recursion to traverse matchsticks
// for loop to traverse each sides
// add a stick
// recurse to place next stick in side 
// remove a stick - continue to try next place

// aglo
// sort in descending order - to reduce recursion overhead - 