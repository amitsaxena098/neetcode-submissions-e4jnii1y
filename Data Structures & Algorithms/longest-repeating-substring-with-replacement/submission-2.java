class Solution {
    public int characterReplacement(String s, int k) {
        
        if(s.isEmpty()) {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }
        //AAABABB
        int l = 0;
        int maxLength = 0;
        int maxFreq = 0;
        int[] freq = new int[26];
        Arrays.fill(freq, 0);
        for(int r = 0; r < s.length(); r++) {
            freq[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(r) - 'A']);
            
            if((r-l+1) - maxFreq > k) {
                while( (r-l+1) - maxFreq > k) {
                    freq[s.charAt(l) - 'A']--;
                    l++;
                }
            }
            maxLength = Math.max(maxLength, r-l+1); 

        }
        return maxLength;
    }
}
