class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars =  new int[n][2];
        for(int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        double prevTime = (double) (target - cars[0][0]) / cars[0][1];
        int fleets = 1; 
        for(int i = 1; i < n; i++){
            double curTime = (double) (target - cars[i][0]) / cars[i][1];
            if(curTime > prevTime){
                fleets++;
                prevTime = curTime;
            }
        }
        return fleets;
    }
}

// based on time of each car -> if current car is slower than car ahead of it -> it form a fleet
