class Solution {
    List<String> res = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for(String word : wordDict) dict.add(word);
        dfs(s, 0, new ArrayList<>(), dict);
        return res;
    }

    private void dfs(String s, int start, List<String> sentence,Set<String> dict){
        if(start == s.length()){
            res.add(String.join(" ", sentence));
            return;
        }

        for(int i = start; i < s.length(); i++){
            String word = s.substring(start, i + 1);
            if(!dict.contains(word)) continue;
            sentence.add(word);
            dfs(s, i + 1, sentence, dict);
            sentence.remove(sentence.size() - 1);
        }
    }
}

// to form a word
// it is similar to sides

// expand the string till valid word is formed
// reach till end and return the sentence
// remove the last word keep expanding the current string