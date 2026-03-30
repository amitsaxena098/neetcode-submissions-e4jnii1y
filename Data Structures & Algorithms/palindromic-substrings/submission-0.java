class Solution {
    Map<String, Integer> dp = new HashMap<>();
    public int isPalindrome(String s, int i, int j) {
        if(i >= j) return 1;
        if(dp.containsKey(i+""+j)) {
            return dp.get(i+""+j);
        }
        int thisPalindrome = s.charAt(i) == s.charAt(j) ? isPalindrome(s, i+1, j-1) : 0;
        dp.put(i+""+j, thisPalindrome);
        return thisPalindrome;
    }
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                count += isPalindrome(s, i, j);
            }
        }
        return count;
    }
}
