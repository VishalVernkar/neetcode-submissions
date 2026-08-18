class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String s : paths){
            if(s.isEmpty() || s.equals(".")) {
                continue;
            } else if(s.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            } else {
                stack.push(s);
            }
        } 

        StringBuilder sb = new StringBuilder("/");

        for(int i = 0; i < stack.size() - 1; i++){
            sb.append(stack.get(i));
            sb.append("/");
        }

        if(!stack.isEmpty()) sb.append(stack.pop());

        return sb.toString();
    }
}

// I want to solve this in time and I can do it