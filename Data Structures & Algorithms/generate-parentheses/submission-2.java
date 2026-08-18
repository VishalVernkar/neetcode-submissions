class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(n, 0, 0, "");
        return res;
    }

    private void dfs(int n, int openN, int closeN, String cur){
        if(openN == closeN && openN == n){
            res.add(cur);
            return;
        }

        if(openN < n){
            dfs(n, openN + 1, closeN, cur + "(");
        }

        if(openN > closeN){
            dfs(n, openN, closeN + 1, cur + ")");
        }
    }
}

// at a give point we can choose 
// open or close
// open has to be there before close 
// open - when open is there
// close - only when open is greater than close
// we add to result when - open == close and open == n

// brute force
// add open
// add close 
// validate and get only o=valid ones - 

