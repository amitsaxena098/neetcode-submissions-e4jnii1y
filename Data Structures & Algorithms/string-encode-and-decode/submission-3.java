class Solution {
    

    public String encode(List<String> strs) {
        String str = "";
        for(String curr : strs) {
            int len = curr.length();
            str += len + "#" + curr;
        }
        return str;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        for(int i = 0;i < str.length(); i++) {
            int j = i;
            String countStr = "";
            while(str.charAt(j) != '#') {
                countStr += str.charAt(j);
                j++;
            }
            int count = Integer.valueOf(countStr);
            String thisStr = "";
            for(int k = j+1; k <= j + count; k++) {
                thisStr += str.charAt(k);
            }
            res.add(thisStr);
            i = j + count;
        }
        return res;

    }
}
