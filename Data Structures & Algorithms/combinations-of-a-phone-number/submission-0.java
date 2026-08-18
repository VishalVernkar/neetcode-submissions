class Solution {
    private String[] map= {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.isEmpty()) return res;

        StringBuilder sb = new StringBuilder();
        backtrack(digits, 0, sb, res);
        return res;
    }

    private void backtrack(String digits, int idx, StringBuilder sb, List<String> res){
        if(sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }

        String chars = map[digits.charAt(idx) - '0'];
        for(int i = 0; i < chars.length(); i++){
            sb.append(chars.charAt(i));
            backtrack(digits, idx + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

// 6:40 - 7:00

// Question
// I have given digits
// each digit is linked to set of characters
// so just like a key pad
// eaht are all the permutation of the characters I can get when I type the difits

// 34
// dh, dg, di ...

// steps
// i need to place the chars in number of digits
// for loop to choose chars
// add char i
// recursion to move to next digit
// remove char i

// algo
// create a array of digits - its chars map
// if the length of string is equal to digits length - add to res list
// get the current digit
// for each char in the current digit
// add char i
// recurse to next digit
// remove char i
// end