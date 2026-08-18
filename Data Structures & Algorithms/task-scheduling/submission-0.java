class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c: tasks){
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();

        for(int cnt : freq){
            if(cnt != 0) maxHeap.offer(cnt);
        }

        System.out.println(Arrays.deepToString(maxHeap.toArray()));

        int time = 0;
        while( !q.isEmpty() || !maxHeap.isEmpty()){
            time++;
            if(maxHeap.isEmpty()){
                time = q.peek()[1];
            } else {
                int cnt = maxHeap.poll() - 1;
                if(cnt > 0) q.offer(new int[]{cnt, time + n});

            }

            if(!q.isEmpty() && time == q.peek()[1]){
                maxHeap.offer(q.poll()[0]);
            }
        }

        return time;
    }
}

// 5:27 - 5:44

// Question
// len of possible sequence
// posible sequence? - a same process can only performed after n sequence


// steps
// The sequqnce arrangement depends on the max freq task
// to get the minimum number of CPU cycles:
// the max freq tasks should be arranged first
// then next nax freq tasks
// we can use heap for getting the max at the top
// once we perform a task we can set it down for cool down -> till n cycles -> once we reach that cycle we can
// perform this task again
// to set it for coold down - we can use a queue
// we take the max freq task from heap - we always perform based on this priority
// if we reach tasks that are in cool down - we add it back to heap - to make it available to be performed
// if no tasks are there in heap we move to tasks available in queue

// algo
// create a freq map - 26
// add the freq to heap - as we need to determine the no fo cycles - using freq is enough
// create a queue
// traverse until q or heap is not empty
// take task from heap
// we need time - first task we always start from 1 - once we perofrm a task - we need a way to put it back in heap after n cycles 
// we can use time for that - update in queue - freq, time + n
// perform it - update its next cycle  in queue
// if there is a task available in queue - add it to heap



// This is taking time - I should be able to complete other tasks today
// there is no clarity what I'm doing next - only foing with hop and expectations that I'll complete 
// this topic and many more
// this is not helping - determine what I'm going to do today - take what is reality now - note what are my expectations
// plan reaching that.
// next I'll do that - I'll solve problems now
// I want to do this right - this give good clarity

// what can I do here to improve speed?
// 1. Also focus on Improve my speed - every time slightly






















// (3 - 1) * (3 + 1) + 1
// 8 + 0


// ex -> n = 1
// a - 2
// b - 2
// c - 2
// (2 - 1)(1+1) = 2 
// 2 + maxFcnt = 2 + 3 = 5
// ababc-c
// cababc