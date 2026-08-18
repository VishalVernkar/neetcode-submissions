class Solution {

    public String encode(List<String> strs) {
        String res = "";
        for(String str: strs ){
            res+=str+";";
        }
        if(res.isEmpty()) return null;
        res=res.substring(0,res.length()-1);
        return res;
    }

    public List<String> decode(String str) {
        if(str == null) return new ArrayList<>();
        return List.of(str.split(";"));
    }
}
