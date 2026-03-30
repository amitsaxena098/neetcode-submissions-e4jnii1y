class Solution {
    public int minDistance(String word1, String word2) {
        return ways(word1, word2, 0, 0);
    }

    public int ways(String word1, String word2, int ind1, int ind2) {
        if(ind1 > word1.length()-1) {
            return word2.length() - ind2;
         } 
        if(ind2 > word2.length()-1) {
            return word1.length() - ind1;
         }
        if(word1.charAt(ind1) == word2.charAt(ind2)) {
            return ways(word1, word2, ind1+1, ind2+1);
        } else {
            int insert = 1 + ways(word1, word2, ind1, ind2+1);
            int delete = 1 + ways(word1, word2, ind1+1, ind2);
            int replace = 1 + ways(word1, word2, ind1+1, ind2+1);
            return Math.min(insert, Math.min(delete, replace));
        }
    }
}
