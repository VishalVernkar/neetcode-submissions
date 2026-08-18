class Solution {
    public int lastStoneWeight(int[] stones) {
       PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

       for(int stone : stones){
            maxHeap.offer(stone);
       }


       while(!maxHeap.isEmpty()){
            if(maxHeap.size() == 1) return maxHeap.poll();
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            if(stone1 != stone2){
                maxHeap.offer(Math.abs(stone1 - stone2));
            }
       }

       return 0;
    }
}

// 10:31 - 10:50

// Question
// In a array take 2 heavy stones
// smash them
// if both are equal - they are destroyed
// if not -> get the differnce and store it
// retrun last stone remaining

// Hint: Heap

// Steps
// create a max heap
// take two max stones
// smash - if equal continue
// else, add differnce in heap
// when one stone remains - return res;
