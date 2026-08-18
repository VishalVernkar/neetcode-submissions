class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return backtrack(s, 0, dict, memo);
    }

    private List<String> backtrack(String s, int start, Set<String> dict, Map<Integer, List<String>> memo){
        if(memo.containsKey(start)) return memo.get(start);
        List<String> list = new ArrayList<>();
        if(start == s.length()) {
            list.add("");
            return list;
        }

        for(int end = start; end < s.length(); end++){
            String word = s.substring(start, end + 1);
            if(dict.contains(word)){
                List<String> subList = backtrack(s, end + 1, dict, memo);

                for(String subSentence : subList){
                    if(subSentence.isEmpty()){
                        list.add(word);
                    } else {
                        list.add(word + " " + subSentence);
                    }
                }
            }
        }
        memo.put(start, list);
        return list;
    }
}

// 7:14 - 7:30

// This problem is similar to palindrome partitioning
// but we can implement a - a optimized one - using dynamic programming
// here we can see that we rebuild - same subtring mutiple times
// we can store the valid part sentences - starting from bottom of recursion tree
// we can build the sentences - using those stored valid part sentences
// finally we return all the valid sentences formed


// steps 
// hashmap to store - index to List<String> - whic stores all the valid sentences from the end - that makes up complete sentence
// once we reach the end of strinf - we have valid sentence - to form the sentence in valid format we use "" empty string 
// then we take each substring check if it is a valid word
// then we recurse to continue
// from the recursion we get the sentences formed from above call
// we use it to attach it to current word and add it to list - here we can see that the top list has the final list of complete formed res
// finally we add it to map
// return the res