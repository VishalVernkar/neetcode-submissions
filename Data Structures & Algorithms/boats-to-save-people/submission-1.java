class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        int boats = 0;
        while(l<=r){
            int sum = people[l] + people[r];
            if(sum <= limit){
                boats++;
                l++;
                r--;
            } else {
                boats++;
                r--;
            } 
        }
        return boats;
    }
}

// Question 
// I can try sorting 
// use left and right pointer to find the number of boats
// now for a boat - 
// biggest weight must go with smallest weight?
// if l + r <= limit
// l++ r-- , boat++
// if l + r > limit
// r--, boat++

// 1 2 2 3 3
// 3 -> 1
// 3 -> 1
// 2 1 -> 1
// 1

