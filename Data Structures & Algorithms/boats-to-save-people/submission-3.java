class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        int boats = 0;
        while(l <= r){
            if(people[r] + people[l] <= limit){
                boats++;
                l++; r--;
            } else {
                boats++;
                r--;
            }
        }
        return boats;
    }
}

// 16:36

// two pointers
// sort
// we move the max ones first
// 