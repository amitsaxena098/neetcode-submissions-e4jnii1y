class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) {return "";}

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();
        int count = 0;
        for(int i = 0; i < t.length(); i++) {
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0;
        int start = 0;
        int resLength = Integer.MAX_VALUE;;
        String res = "";
        int have = 0, need = countT.size();

        if(t.length() > s.length()) {
            return res;
        }
        for(int r = 0; r < s.length(); r++) {
            Character c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if(countT.containsKey(c) && window.get(c) == countT.get(c)) {
                have += 1;
            }
            while(have == need) {
                if( r - l + 1 < resLength) {
                    resLength = r - l + 1;
                    start = l;
                }
                window.put(s.charAt(l), window.get(s.charAt(l))-1);
                if(countT.containsKey(s.charAt(l)) && window.get(s.charAt(l)) < countT.get(s.charAt(l))) {
                    have -= 1;
                }
                l++;
            }
        }

        if(resLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, resLength + start);
           
    }
}
