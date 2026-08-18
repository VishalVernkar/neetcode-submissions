class Solution {
    public boolean isAnagram(String s, String t) {
      if(s.length() != t.length()){
            return false;
        }
        int n = s.length();
        int value;
        Map<Character, Integer> sfreq = new HashMap<>();
        Map<Character, Integer> tfreq = new HashMap<>();
        for(int i = 0; i < n ; i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(sfreq.containsKey(sc)){
                value = sfreq.get(sc);
                sfreq.put(sc, value+1);
            } else {
                sfreq.put(sc, 0);
            }

            if(tfreq.containsKey(tc)){
               value = tfreq.get(tc);
               tfreq.put(tc, value+1);
            } else {
                tfreq.put(tc, 0);
            }
        }

        return tfreq.equals(sfreq);


    }
}
