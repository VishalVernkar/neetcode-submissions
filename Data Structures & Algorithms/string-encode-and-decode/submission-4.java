class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int n = str.length();
        while(i < n){
            String num = "";
            while(i < n && str.charAt(i) != '#'){
                num = num + str.charAt(i);
                i++;
            }
            int len = Integer.parseInt(num);
            res.add(str.substring(++i, i + len));
            i = i + len;
        }
        return res;
    }
}
