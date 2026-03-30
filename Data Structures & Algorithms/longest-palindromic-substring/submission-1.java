class Solution {
    Map<String, Boolean> dp = new HashMap<>();
    public boolean isPalindrome(String s, int i, int j) {
        if(i >= j) return true;
        if(dp.containsKey(i+""+j)) {
            return dp.get(i+""+j);
        }
        boolean thisPalindrome = s.charAt(i) == s.charAt(j) ? isPalindrome(s, i+1, j-1) : false;
        dp.put(i+""+j, thisPalindrome);
        return thisPalindrome;
    }
    public String longestPalindrome(String s) {
        int count = 0;
        String ans = "";
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                if(isPalindrome(s, i, j) && count < j-i+1) {
                    count = j - i + 1;
                    ans = s.substring(i, j+1);
                }
            }
        }
        return ans;
    }
}
