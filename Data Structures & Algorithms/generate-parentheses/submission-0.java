class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        count("(", 1, 0, n, res);
        return res;
    }

    public void count(String str, int open, int closed, int n, List<String> res) {
        if(open == n && closed == n) {
            res.add(str);
        }
        if(closed < open) {
            if(open < n)
                count(str + "(", open+1, closed, n, res);
            if(closed < n)
                count(str + ")", open, closed+1, n, res);
        } else {
            if(open < n)
                count(str + "(", open+1, closed, n, res);
        }
    }
}
