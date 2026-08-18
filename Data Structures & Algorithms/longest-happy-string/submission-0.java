class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a1,b1) -> b1[1] - a1[1]);
        if(a > 0) maxHeap.offer(new int[]{'a', a});
        if(b > 0) maxHeap.offer(new int[]{'b', b});
        if(c > 0) maxHeap.offer(new int[]{'c', c});

        StringBuilder res = new StringBuilder();

        while(!maxHeap.isEmpty()){
            int[] first = maxHeap.poll();
            int len = res.length();
            if(len > 1 && res.charAt(len - 1) == first[0] && res.charAt(len - 2) == first[0]){
                if(maxHeap.isEmpty()) break;
                int[] second =  maxHeap.poll();
                res.append((char) second[0]);
                second[1]--;
                maxHeap.offer(first);
                if(second[1] > 0) maxHeap.offer(second);
            } else {
                res.append((char) first[0]);
                first[1]--;
                if(first[1] > 0) maxHeap.offer(first);
            }
        }

        return res.toString();
        
    }
}

// 7:18
// Question
// Happy stirng
// has only a b c
// cannot have more than two sam chars
// return the possible string to build - once we can't we return as much as we built

// steps
// as we need to spread the max char first as much as possible
// we can use heap - to get the max char
// make sure we don't append same char more than twice
// if it is more than twice -> pick the second max char
// continue till we are able to build it

// algo
// create a heap - stores int[]{char, freq}
// create sb -> res 
// traverse
// poll the first char
// check if string len is > 1 and last and before last is not same as first
// if yes -> take second -> append
// if no, append first
// 