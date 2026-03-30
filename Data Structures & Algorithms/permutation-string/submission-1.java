class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq =  new int[26];
        Arrays.fill(freq, 0);
        for(Character c : s1.toCharArray()) {
            freq[c - 'a']++;
        }
        
        int hash = Arrays.hashCode(freq);
       

        for(int i = 0; i <= s2.length()-s1.length(); i++) {
            int[] currFreq = new int[26];
            Arrays.fill(currFreq, 0);
            String str = "";
            for(int j = i; j < i+s1.length(); j++) {
                currFreq[s2.charAt(j) - 'a']++;
                str += s2.charAt(j);
            }
            
            if(hash == Arrays.hashCode(currFreq)) {
                return true;
            }
        }
        return false;
    }
}
