class Solution {
    public int characterReplacement(String s, int k) {
        // It is about ability to solve problems
        // Improve that by solving with my own approach
        // Reduce the time taken
        // - observe - how I approach Easy, medium, hard problems

        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int l = 0;
        int max = 0;
        for(int r=0; r<n; r++){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0) + 1);
            max = Math.max(max, map.get(s.charAt(r)));
            if((r-l+1)-max > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
        }
        return (max + k > n)? n:max+k;
        
    }
}
