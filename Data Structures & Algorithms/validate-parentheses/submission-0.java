class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(Character c: s.toCharArray()) {
            if(!(stack.isEmpty()) && ( (c == ')' && stack.peek() == '(') || 
            (c == ']' && stack.peek() == '[') ||
            (c == '}' && stack.peek() == '{'))) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if(stack.size() != 0) {
            return false;
        }
        return true;
    }
}
