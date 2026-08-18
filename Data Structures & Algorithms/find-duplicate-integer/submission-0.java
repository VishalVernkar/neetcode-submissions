class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }

        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2) {
                return slow;
            }
        }
    }
}

// can I use boyer moore voting algorithm - it works if n is >n/2 
// no not gonna work

// 1 2 3 2 4
// 
// fast slow??

// does this help
// range 1 - n numbers
// 

// use min ?
// use max ?
// use sum of elements?


// this is an array, 
// in linked list
// linked list?


// we can do it by modifying array, by visiting each index and placing them in right position

// we can do by placing each element in their index and if each index already has element then it is a duplicate but
// I cannot modify the array
// or

// even if I use linked list isn't it going to be o(n) space