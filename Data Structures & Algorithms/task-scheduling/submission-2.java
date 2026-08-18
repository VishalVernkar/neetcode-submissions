class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c: tasks){
            freq[c - 'A']++;
        }

        int maxFreq = 0;
        for(int i = 0; i < 26; i++){
            maxFreq = Math.max(maxFreq, freq[i]);
        }

        int maxCount = 0;
        for(int cnt : freq){
            if(cnt == maxFreq) maxCount++;
        }

        return Math.max((maxFreq - 1) * (n  + 1) + maxCount, tasks.length);
    }
}

// Ex -> A-3, B-1, C-1
// n = 3
// A - 3 -> size = (3 + 1) * (3 - 1) + 1  = 9

// ex 
// A - 3, B - 3
     //  => (n + 1)(f - 1)        
// A - 3 => (2 + 1)(3 - 1) + 1= 7

// start 0 -> end 6
// b also ends at 6
// start 1 -> at 7
// so total is 8

// ex 2
// A - 2
// B - 2
// C - 1
// D - 1
// n = 1 => n + 1 = 2 

// A
// start = 0, end = 2 * 1 = 2
// B
// start = 1, end = 2 * 1 = 2 + 1 = 3
// C
// start = 4, end = 2 * 0 = 0 + 2 = 4
// D
// start = 5, end = 2 * 0 = 0 + 3 = 5

// I'll move to next question

// 6:57 - 7:07
// 

//  hashmap -> ele -> it's next position
// taverse the array
// append each element
// a - curr = 1 -> update in map its next pos -> a -> n + 1 -> 4 + 1
// limit 5
// < 5 
// i can add different elements
// 