class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }
        int i = 0, j = 1;
        int maxLength = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(i));
        while(j < s.length()) {
            if(set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            } else if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                maxLength = Math.max(maxLength, j-i+1);
                j++;
            }
        }
        return maxLength;
    }
}
