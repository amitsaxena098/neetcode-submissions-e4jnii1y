class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            int[] count = new int[26];
            for(int j = 0; j < strs[i].length(); j++) {
                count[strs[i].charAt(j) - 'a']++;
            }
            String key = Arrays.toString(count);
            if(map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                map.put(key, new ArrayList<>(Arrays.asList(strs[i])));
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;

    }
}
