class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(String s, int start, List<String> list, List<List<String>> res){
        if(start == s.length()) {
            res.add(new ArrayList<>(list));
        }

        for(int end = start; end < s.length(); end++){
            String sub = s.substring(start, end + 1);
            if(isPalindrome(sub)){
                list.add(sub);
                backtrack(s, end + 1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int l = 0; int r = s.length() - 1;
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

}

// 6:32 - 6:47

// Question
// divide the string in such a way that, every divded word is a palindrom get all the possible palindromes

// steps
// i can get all the substrings and see if it forms a palindrome till the end
// i can use backtracking to get all the possiblities
// pick a sub string - if it is a palindrome - move to next substring - recurse
// backtrack - remove the current substring - continue iterating to try with next substring

// algo
// if we are at end of string - we have a right palindrome partition
// from the i=start - till the len of string
// get first substring from start, i + 1 -> increase the substring
// if it is a valid substring
// recurese - to 
// backtrack
// coninue.
