class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>());
        return res;
    }

    private void dfs(String s, int idx, List<String> list){
        if(idx == s.length()){
            res.add(new ArrayList<>(list));
        }

        for(int i = idx; i < s.length(); i++){
            if(isPalindrome(s.substring(idx, i + 1))){
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
