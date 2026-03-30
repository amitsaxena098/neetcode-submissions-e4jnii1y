class Solution {
    Map<String, Integer> dp = new HashMap<>();
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2, 0, 0);
    }
    public int lcs(String s1, String s2, int i, int j) {
        if(i > s1.length()-1 || j > s2.length()-1) {
            return 0;
        }
        if(dp.containsKey(i+","+j)) {
            return dp.get(i+","+j);
        }
        int pickIJ = 0;
        int pickI = 0, pickJ = 0;
        if(s1.charAt(i) == s2.charAt(j)) {
            pickIJ = 1 + lcs(s1, s2, i+1, j+1);
        } else {
            pickI = lcs(s1, s2, i+1, j);
            pickJ = lcs(s1, s2, i, j+1);
        }
        dp.put(i+","+j, Math.max(pickIJ, Math.max(pickI, pickJ)));
        return dp.get(i+","+j);
    }

}
