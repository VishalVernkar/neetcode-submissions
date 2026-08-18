class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++) map.put(order.charAt(i), i);

        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                System.out.println(words[i] +  " " + words[j]);
                boolean res = compare(words[i], words[j], map);
                System.out.println(res);

                if(!res) return false;
            }
        }
        return true;
    }

    private boolean compare(String a, String b, Map<Character, Integer> map){
        int size = (a.length() > b.length())? b.length() : a.length();
        int l = 0; 
        int count = 0;
        while(l < size){
            if(map.get(a.charAt(l)) < map.get(b.charAt(l))){
                return true;
            }else if(map.get(a.charAt(l)) > map.get(b.charAt(l))){
                return false;
            } else {
                count++;
            }
            // if(a.charAt(l) == b.charAt(l)) count++;
            l++;
        }

        // return (count == size && a.length() > b.length())? false : fa;
        return (count == size && a.length() <= b.length())? true: false;
    }
}