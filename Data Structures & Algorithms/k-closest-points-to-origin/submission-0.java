class Solution {
    private class Pair{
        int[] point;
        int d;

        Pair(int[] point, int d){
            this.point = point;
            this.d = d;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> p1.d - p2.d);

        for(int[] point : points){
            int d = (int) Math.pow(point[0], 2) + (int) Math.pow(point[1], 2);
            minHeap.offer(new Pair(point, d));
        }

        int[][] res = new int[k][2];
        
        while(k > 0){
            res[--k] = minHeap.poll().point;
        }

        return res;

    }
}

// 11:40 - 12:00

// 17:47 - 17:57 - 10 mins

// Question
// return the k points close to 0,0

// Brute force
// calculate the distance of all the points to 0,0
// get the k smaller ones by sorting
// O(n + n log n)

// Optimal
// hint: heap

// can I just compare the x y values of each point to see which is closer

// steps
// 



// Now I have to solve it in time
// easy way is go direct approach
