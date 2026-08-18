class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> minCapital = new PriorityQueue<>((a,b) -> capital[a] - capital[b]);  
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>((a,b) -> profits[b] - profits[a]);

        int n = capital.length;
        for(int i = 0; i < n; i++){
            minCapital.offer(i);
        }  

        while(k > 0){
            k--;
            while(!minCapital.isEmpty() && capital[minCapital.peek()] <= w){
                maxProfit.offer(minCapital.poll());
            }
            if(maxProfit.isEmpty()) break;
            w +=  profits[maxProfit.poll()];
        }

        return w;
    }
}

// 10:51 - 11:05

/// Question

// we have a wCapital
// we need to pick the highest profitable project based on the capital availble
// increase capital
// pick again profitable project

// steps

// from capital pick get avaialble project based on current capital
// from the available projeects pick the -> highest profit projects

// this way - pick upto k projects

// algo
// we a use min heap for capital
// and load the projects based on capital available to the max heap -> so that we can pick highest profit project
// first load all the projects in capital heap
// based on avaialbel capital - get all the projects <= w
// load them to max heap of profits heap
// pick one
// continue - till krpjects;