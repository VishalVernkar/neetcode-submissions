class Solution {
    List<String> res;
    String[] map;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.isEmpty()) return res;
        map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(digits, 0, new StringBuilder());
        return res;
    }

    private void dfs(String digits, int idx, StringBuilder cur){
        if(idx == digits.length()){
            res.add(cur.toString());
            return;
        }

        String chars = map[digits.charAt(idx) - '0'];
        for(char c : chars.toCharArray()){
            cur.append(c);
            dfs(digits, idx + 1, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}

// for each string
// of the digit
// we take first char - and move to next digit
// we remove the current char and move

