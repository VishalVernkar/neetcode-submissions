class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] tasksList = new int[n][3];

        for(int i = 0; i < n; i++){
            tasksList[i][0] = tasks[i][0];
            tasksList[i][1] = tasks[i][1];
            tasksList[i][2] = i;
        }

        Arrays.sort(tasksList, (a,b) -> a[0] - b[0]);
        PriorityQueue<int []> minHeap = new PriorityQueue<>((a,b) -> a[0] == b[0]? a[1] - b[1] : a[0] - b[0]);

        int[] res = new int[n];
        int idx = 0;
        int i = 0;

        int time = 0;
        while(idx < n){
            while(i < n && tasksList[i][0] <= time){
                minHeap.offer(new int[]{tasksList[i][1], tasksList[i][2]});
                i++;
            }

            if(minHeap.isEmpty()){
                time = tasksList[i][0];
            } else {
                int[] cur = minHeap.poll();
                time += cur[0];
                res[idx++] = cur[1];
            }
        }

        return res;
    }
}

// 7:18 - 7:30

// Question
// Understand question
// tasks - start time -> processing time
// the tasks are availble to be performed when cpu reaches that time
// these avaialble tasks are picked based on shortest time
// give order in which these tasks are performed

// Steps
// we need to sort the tasks based on start time - so that we can pick them in order
// We can use min heap to get the shortest time - if processing time is same - we pick based on index
// We start time from 0
// what ever the task avaialble at this time we add it to heap
// we take the sortest one from heap -> we perform -> add processing time to time
// if heap is empty we take next one available from tasks array - update time to this start time
// in the next iteration the updated time - with performed tasks - will take all the avaialble task in heap

// algo
// sort the array -> based on start time
// create a heap -> if processing time is same - we pick based on index
// while res array is not full
// we add all the available tasks <= to the current time
// if heap is empty -> we take from arry
// else we perform update time
