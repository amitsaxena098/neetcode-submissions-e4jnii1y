class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            int a, b;
            switch(token) {
                case "+":
                    a = stack.peek();
                    stack.pop();
                    b = stack.peek();
                    stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    a = stack.peek();
                    stack.pop();
                    b = stack.peek();
                    stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    a = stack.peek();
                    stack.pop();
                    b = stack.peek();
                    stack.pop();
                    stack.push(b * a);
                    break;
                case "/":
                    a = stack.peek();
                    stack.pop();
                    b = stack.peek();
                    stack.pop();
                    stack.push(b / a);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }
        return stack.peek();
    }
}
