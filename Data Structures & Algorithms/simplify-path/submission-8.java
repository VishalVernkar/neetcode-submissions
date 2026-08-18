class Solution {
    public String simplifyPath(String path) {
        StringBuilder currString = new StringBuilder();
        StringBuilder parentDir = new StringBuilder("..");
        StringBuilder currentDir = new StringBuilder(".");
        Stack<String> stack = new Stack<>();
        path += "/";
        int n = path.length();
        for(int i=0 ; i<n ; i++){
            char c = path.charAt(i);
            if(c == '/'){
                if(currString.compareTo(parentDir) == 0) {
                    if(!stack.isEmpty())stack.pop();
                } else if (!currString.isEmpty() && currString.compareTo(currentDir) != 0) {
                    stack.push(currString.toString());
                }
                currString.setLength(0);
            } else {
                currString.append(c);
            }
        }
        // if(!currString.isEmpty()){
        //     if(currString.compareTo(parentDir) == 0) {
        //         if(!stack.isEmpty())stack.pop();
        //     } else if (currString.compareTo(currentDir) != 0) {
        //         stack.push(currString);
        //     }
        // }   
        return "/" + String.join("/", stack); // O(2n) solution;
        
    }
    // Question
    // Hint stack
    // I'm trying to remember direct solution I studied
    // I want to able to come up with that solution
    // By understanding the question

    // whenever there is a root directory I can pop the directory from stack

    // Read each char
    // when there is /
    // push last folder name to stack 
    // start creating a new folder name
    // if foldername matches .. pop the stack
    // else push it
}