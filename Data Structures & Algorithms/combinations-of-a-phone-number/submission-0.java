class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        letter(digits, 0, new String(""), map);
        return res;

    }
    public void letter(String digits, int index, String curr, Map<Character, String> map) {
        if(index > digits.length() || index < 0) return;
        if(curr.length() == digits.length()) {
            res.add(curr);
            return;
        }
        String str = map.get(digits.charAt(index));
        for(int i = 0; i < str.length(); i++) {
            curr += str.charAt(i);
            index++;
            letter(digits, index, curr, map);
            curr = curr.substring(0, curr.length()-1);
            index--;
        }
    }

}
