class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for(String str : strs){
            encoded.append(str.length()).append("#").append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        int n = str.length();
        List<String> res = new ArrayList<>();
        int num = 0;
        while(i < n){
            char c = str.charAt(i);
            if(c >= '0' && c <= '9'){
                num = num * 10 + (c - '0');
            } else if(c == '#'){
                res.add(str.substring(i + 1, i + num + 1));
                i = i + num;
                num = 0;
            }
            i++;
        }
        return res;
    }
}

//

// 
