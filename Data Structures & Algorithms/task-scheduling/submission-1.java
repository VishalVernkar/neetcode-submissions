class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c: tasks){
            freq[c - 'A']++;
        }

        int maxFreq = 0;
        int idx = 0;
        for(int i = 0; i < 26; i++){
            if(freq[i] > maxFreq){
                maxFreq = freq[i];
                idx = i;
            }
            // maxFreq = Math.max(maxFreq, count[i]);
        }

        int idle = (maxFreq - 1) * n;
        for(int i = 0; i < 26; i++){
            if(i != idx) idle -= Math.min(maxFreq - 1, freq[i]);
        }

        return Math.max(0, idle) + tasks.length;
    }
}

// Arrangement

// we can use determining the min idle required and add the remaining tasks 
// the ilde depends on the max freq task
// we get that from idele maxf - 1 * n 
// we fill gaps from all other tasks
// we add tasks.len to the idle to get result