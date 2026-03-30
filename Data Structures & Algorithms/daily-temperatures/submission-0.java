class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        stack.push(temperatures.length-1);
        for(int i = temperatures.length-2; i >= 0 ; i--) {
            if(temperatures[i] >= temperatures[stack.peek()]) {
                while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    res[i] = 0;
                } else {
                    res[i] = stack.peek() - i;
                }
                stack.push(i);
            } else {
                res[i] = stack.peek() - i;
                stack.push(i);
            }
        }
        return res;
    }
}
