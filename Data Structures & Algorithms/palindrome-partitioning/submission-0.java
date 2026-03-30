class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, 0, new ArrayList<>());
        return res;
    }
    public void dfs(String s, int i, List<String> curr) {
        if(i >= s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int l = i; l < s.length(); l++) {
            if(palindrome(s, i, l)) {
                curr.add(s.substring(i, l+1));
                dfs(s, l+1, curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    public boolean palindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) { return false; }
            i++;
            j--;
        }
        return true;
    }
}
