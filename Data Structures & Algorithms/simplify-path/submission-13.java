class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for(String str : path.split("/")){
            if(str.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            } else if(str.equals(".")){
                continue;
            } else {
                if(!str.isEmpty()) stack.push(str);
            }
        }
        return "/"+String.join("/", stack);
    }
}

// I can sit and I can do it now > no I don't really need break
// I'm pushing myself here -> only this will make me reach my target and goals

// split
// split at "/"
// process each directory
// . - don't add
// .. pop
// join at the end

// 