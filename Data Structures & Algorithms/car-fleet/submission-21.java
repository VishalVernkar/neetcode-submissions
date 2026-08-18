class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        int[][] cars = new int[n][2];

        for(int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        int fleets = 1;
        double prev = (double) (target - cars[0][0])/cars[0][1];
        for(int i = 1; i < n; i++){
            double cur = (double) (target - cars[i][0])/cars[i][1];
            if(cur > prev){
                fleets++;
                prev = cur;
            }
        }

        return fleets;

    }
}

// if the current car is slower than car ahead of it - it forms a fleet and we update its speed

