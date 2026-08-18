class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack("", n, n, res);
        return res;
    }

    private void backtrack(String curStr, int open, int close, List<String> res){
        if(open == 0 & close == 0){
            res.add(curStr);
        }

        if(open > 0) backtrack(curStr + "(", open - 1, close, res);
        if(open < close) backtrack(curStr + ")", open, close - 1, res);
    }
}

// 4:47 - 5:00

// Question
// all possible paranthesis - with given pair
// ()()()
// ((())) (()()) (())() ()(()) ()()()

// intuition
// for the valid paranthsis
// the open is always first
// then closed - closed must be used only when there are moreopen used then closed

// algo
// when open = 0 and close = 0 -> we have one comlete res
// if(open > 0)
//  use open
//  backtrack 
// 
// if(open < closed)
//  use closed
//  baclktrack