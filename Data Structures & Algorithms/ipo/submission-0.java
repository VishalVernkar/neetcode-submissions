class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for(int i = 0; i < n; i++){
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        while(k > 0){
            k--;
            List<Integer> idx = new ArrayList<>();
            for(int i = 0; i < n; i++){
                // get all the projects whose capial <= w
                if(projects[i][0] >= 0 && projects[i][0] <= w){
                    idx.add(i);
                }
            }
            int len = idx.size();
            if(len == 0) continue;
            int max = idx.get(0);
            for(int i = 0; i < len; i++){
                int j = idx.get(i);
                // pick one with  max profit
                if(projects[j][1] >= 0 && projects[j][1] > projects[max][1]){
                    max = j;
                }
            }
            w = w + projects[max][1];
            System.out.println(projects[max][1] + " " + max);
            projects[max][0] = -1;
            projects[max][1] = -1;
        }

        return w;

    }
}

//                                0 1 2 3 4
// Input: k = 4, w = 2, profit = [2,3,1,5,3], capital = [4,4,2,3,3]

// k = 1
// 

// w = 2
// 2 -> p = 1

// w = 3
// 3 -> p = 5

// w = 8
// 1 -> p = 3

// w = 11
// 4 -> p = 3
// w = 14