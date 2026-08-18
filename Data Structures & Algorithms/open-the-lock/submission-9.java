class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visit = new HashSet<>(Arrays.asList(deadends));
        Queue<String> q = new LinkedList<>();
        if (visit.contains("0000")) return -1;
        q.offer("0000");
        visit.add("0000");
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                if(cur.equals(target)) return level;
                List<String> list = getAllPossiblities(cur);
                for(String comb : list){
                    if(!visit.contains(comb)) {
                        visit.add(comb);
                        q.offer(comb);
                    } 
                }
            }
            level++;
        }
        return -1;
    }

    private List<String> getAllPossiblities(String cur){
        List<String> list = new ArrayList<>();
        char[] arr = cur.toCharArray();
        for(int i = 0; i < 4; i++){
            char temp = arr[i];
            int num = ((temp - '0') + 9) % 10;
            arr[i] = (char)(num + '0');
            list.add(new String(arr));
            num = ((temp - '0') + 11) % 10;
            arr[i] = (char)(num + '0');
            list.add(new String(arr));
            arr[i] = temp;
        }
        return list;
    }

}
// back track
// 0000
// at a point - 

// each slot can be moved up or down 
// we try BFS
// we start from 0000
// for each slot we move up or down - we do it for four slots - 
// if it is a dead lock we don't add it to queue










// I want to learn space and time complexiety
// I want to complete SD in one month - get strong in it