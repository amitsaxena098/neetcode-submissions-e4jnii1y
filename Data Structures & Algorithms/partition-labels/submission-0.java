class Solution {
    public List<Integer> partitionLabels(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = s.length()-1; i >= 0; i--) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            }
        }
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < s.length() ; i++) {
            int right = map.get(s.charAt(i));
            for(int j = i+1; j <= right; j++) {
                if(map.get(s.charAt(j)) > right) {
                    right = map.get(s.charAt(j));
                }
            }
            res.add(right - i + 1);
            i = right;
        }
        return res;
    }
}
