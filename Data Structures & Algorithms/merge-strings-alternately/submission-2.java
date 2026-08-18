class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length(); int n2 = word2.length();
        String word = "";
        if(n1 > n2) {
            n1 = n2;
            word = word1;
            n2 = word1.length();
        } else {
            word = word2;
        }

        int i = 0;
        StringBuilder res = new StringBuilder();
        while(i < n1){
            res.append(word1.charAt(i)).append(word2.charAt(i));
            i++;
        }

        while(i < n2){
            res.append(word.charAt(i));
            i++;
        }

        return res.toString();
    }
}

// 4:48

// 