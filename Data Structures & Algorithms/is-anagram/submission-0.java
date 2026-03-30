class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alpha_1 = new int[26];
        int[] alpha_2 = new int[26];
        if(s.length() != t.length()) {
            return false;
        }
        for(int i = 0; i < s.length(); i++) {
            
            alpha_1[s.charAt(i) - 'a']++;
            alpha_2[t.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(alpha_1[i] != alpha_2[i])
                return false;
        }
        return true;
    }
}
