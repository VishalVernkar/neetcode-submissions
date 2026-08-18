class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] p : trust){
            if(map.containsKey(p[0])){
                map.get(p[0]).add(p[1]);
            } else {
                map.put(p[0], new HashSet<>());
                map.get(p[0]).add(p[1]);
            }
        }

        for(int i = 1; i<=n; i++){
            if(!map.containsKey(i)){
                int judge = i;
                for(Set<Integer> set : map.values()){
                    if(!set.contains(judge)) return -1;
                }
                return judge;
            }
        }

        return -1;
    }
}

// create a map - with user - list of user trusts
// at the end the person with empty list is the judge 