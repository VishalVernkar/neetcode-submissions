class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        System.out.println(dict);
        List<String> res = new ArrayList<>();
        backtrack(s, 0, dict, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(String s, int start, Set<String> dict, List<String> sentence, List<String> res){
        System.out.println(sentence);

        if(start == s.length()){
            // System.out.println(sentence);
            
            res.add(String.join(" ", sentence));
        }

        for(int end = start; end < s.length(); end++){
            System.out.println(s.substring(start, end + 1));
            System.out.println(dict.contains(s.substring(start, end + 1)));

            if(dict.contains(s.substring(start, end + 1))){
                // System.out.println("sentence " + sentence);
                // System.out.println(s.substring(start, end + 1));
                // if(start == s.length()) System.out.println(sentence);
                // System.out.println(sentence);
                sentence.add(s.substring(start, end + 1));
                backtrack(s, end + 1, dict, sentence, res);
                sentence.remove(sentence.size() - 1);
            }
        }
    }
}

// 12:51 - 13:10

// Question 
// add spaces in given string
// find the possible words in dict and create a sentance and add it to the resl list

// steps
// create a hashset of given dict
// just like in the partition of valid palindrome substrings 
// I can use that
// i take each substring -> search in a dictionary - if found continue from next index
// I'll code



// why do I think this is not possible for me?
// I don't know that yet.
// I'm giving it a try.

// I've to 