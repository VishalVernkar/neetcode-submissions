class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if(visited.contains("0000") || visited.contains(target)) return -1;
        Set<String> begin = new HashSet<>();
        begin.add("0000");
        Set<String> end = new HashSet<>();
        end.add(target);
        int turns = 0;
        while(!begin.isEmpty() && !end.isEmpty()){
            if(begin.size() > end.size()){
                Set<String> temp = end;
                end = begin;
                begin = temp;
            }

            turns++;
            Set<String> level = new HashSet<>();
            for(String state : begin){
                visited.add(state);
                char[] arr = state.toCharArray();
                for(int i = 0; i < 4; i++){
                    char temp = arr[i];
                    for(int move : new int[]{1, -1}){
                        arr[i] = (char) ((temp - '0' + move + 10) % 10 + '0');
                        String newState = new String(arr);
                        if(visited.contains(newState)) continue;
                        if(end.contains(newState)) return turns;
                        level.add(newState);
                    }
                    arr[i] = temp;
                }
            }
            begin = level;
        }

        return -1;
    }
}