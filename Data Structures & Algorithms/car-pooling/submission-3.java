class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b) -> a[1] - b[1]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int currentCapacity = 0;

        int start = 0; int n = trips.length;
        for(int i = 0; i < n; i++){

            while(!minHeap.isEmpty() && minHeap.peek()[0] <= trips[i][1]){
                currentCapacity -= minHeap.poll()[1];
            }

            currentCapacity += trips[i][0];
            //start = trips[i][1];
            if(currentCapacity > capacity) return false; 
            minHeap.offer(new int[]{trips[i][2], trips[i][0]});
        }

        return true;
    }
}



// 9:14 - 9:30

// Question
// Car that goes in one direction with capcity c
// multiple group of passangers are looking for a cab in different locations
// return true - if it is possible for the cab to get and complete all the rides
// 

// steps
// limitation is capacity
// capacity gets -> available - when ride completes
// I have to track
// I take a ride
// if a group is available - on the way - if capcity is there I picke them up
// now I have to drop whose distance is short
// for that I can use min heap based on short distance
// I poll shortest rides -> reduce the capacity

// 