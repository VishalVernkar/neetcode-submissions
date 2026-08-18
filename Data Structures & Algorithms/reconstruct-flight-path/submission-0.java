class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> ticket : tickets){
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }

        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        List<String> res = new  ArrayList<>();
        while(!stack.isEmpty()){
            String cur = stack.peek();
            if(!graph.containsKey(cur) || graph.get(cur).isEmpty()){
                res.addFirst(stack.pop());
            } else {
                stack.push(graph.get(cur).poll());
            }
        }

        return res;
    }
}


// using create a graph - with list of min heap - to get the vertices in sorted order
// use stack 
// start from a node
// visit - deep most node 
// once it has no more edges - we add it to list