class Solution {
    public String simplifyPath(String path) {
        String[] chunks = path.split("/+");
        Stack<String> stack = new Stack<>();
        for(String str : chunks){
            if(str.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            } else if(!str.equals(".") && !str.isEmpty()){
                stack.push(str);
            }
        }

        return "/" + String.join("/", stack);
    }
}

// 12:36

// split the string at /+
// push each chunk
// if it is .. pop top of the stack
// 