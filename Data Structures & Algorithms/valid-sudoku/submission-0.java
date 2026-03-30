class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int r = 0; r < board.length; r++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            for(int c = 0; c < board[0].length; c++) {
                if(board[r][c] != '.') {
                    if(row.contains(board[r][c])) {
                        return false;
                    }
                    row.add(board[r][c]);
                }
                if(board[c][r] != '.') {
                    if(col.contains(board[c][r])) {
                        return false;
                    }
                    col.add(board[c][r]);
                }
            }
        }

        Map<String, HashSet<Character>> map = new HashMap<>();
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                int rkey = r/3;
                int ckey = c/3;
                String key = rkey + "" + ckey;
                if(board[r][c] != '.') {
                    
                    if(map.containsKey(key)) {
                        if(map.get(key).contains(board[r][c])) {
                            return false;
                        }
                        map.get(key).add(board[r][c]);
                    } else {
                        map.put(key, new HashSet<>());
                        map.get(key).add(board[r][c]);
                    }
                }
            }
        }
        return true;

    }
}
