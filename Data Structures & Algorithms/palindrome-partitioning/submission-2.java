class Solution {
    List<List<String>> res = new ArrayList<>();
    boolean[][] dp;
    public List<List<String>> partition(String s) {

        // build dp
        // s - 0 - (n - 1)
        // start from dp[n][n]
        // take 00, 01, 02---0n
        //          11, 12
                        //  22
        int n = s.length();
        dp = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(isPalindrome(s.substring(i, j + 1))){
                    dp[i][j] = true;
                }
            }
        }
        res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>());
        return res;
    }

    private void dfs(String s, int idx, List<String> list){
        if(idx == s.length()){
            res.add(new ArrayList<>(list));
        }

        for(int i = idx; i < s.length(); i++){
            if(dp[idx][i]){
                list.add(s.substring(idx, i + 1));
                dfs(s, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }


}

// expand the string till it is a palindrome
// then split and continue to next
// then remove the last palindrome and continue existing string to build the res
