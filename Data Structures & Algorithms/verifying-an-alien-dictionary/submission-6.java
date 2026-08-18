class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] charmap = new int[26];
        for(int i = 0; i < order.length(); i++) charmap[order.charAt(i) - 'a'] = i;

        int n = words.length - 1;
        for(int i = 0; i < n; i++){
            String w1 = words[i];
            String w2 = words[i + 1];

            int l = 0;
            while(l < w1.length()){
                if(l == w2.length()) return false;
                if(w1.charAt(l) != w2.charAt(l)){
                    if(charmap[w1.charAt(l) - 'a'] > charmap[w2.charAt(l) - 'a']) return false;
                    break;
                }
                l++;
            }
        }
        return true;
    }
}

// 6:20

// verifying alien dictionary
// based on letters order
// check if the given order of words is in order

// algo
// we can use map - chars to index - in array map
// if the words are sorted - the adjacent words must be in order
// we compare adjacent words
// for two words
// if chars are equal - continue
// if one word is small and it reached its i == len - it is false becase the big word is before small
// if the char is not equal and 
// w1 char order is big than current word char return false
// else return true