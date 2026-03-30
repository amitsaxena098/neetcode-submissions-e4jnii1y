class Solution {
    boolean found = false;
    public boolean exist(char[][] board, String word) {
     boolean[][] flag = new boolean[board.length][board[0].length];
     for(int i = 0; i < board.length; i++) {
        Arrays.fill(flag[i], false);
     }
     for(int i = 0; i < board.length; i ++) {
        for(int j =0; j < board[0].length; j++) {
            if(board[i][j] == word.charAt(0)) {
                find(board, word, new String(""), flag, i, j, 0);
            }
            if(found) break;
        }
     }
     return found;
    }
    public void find(char[][] board, String word, String curr, boolean[][] flag, int r, int c, int index) {
        if(curr.equals(word)){
            found = true;
            return;
        }
        if(found) return;
        if(r >= board.length || c >= board[0].length || r < 0 || c < 0 || index >= word.length()) return;
        if(flag[r][c] == true) return;
        
        
        if(board[r][c] == word.charAt(index)) {
            curr += board[r][c];
            flag[r][c] = true;
            index++;
            find(board, word, curr, flag, r+1, c, index);
            find(board, word, curr, flag, r-1, c, index);
            find(board, word, curr, flag, r, c+1, index);
            find(board, word, curr, flag, r, c-1, index);
            flag[r][c] = false;
            
        } else {
            curr = "";
            flag[r][c] = true;
            index = 0;
            find(board, word, curr, flag, r+1, c, index);
            find(board, word, curr, flag, r-1, c, index);
            find(board, word, curr, flag, r, c+1, index);
            find(board, word, curr, flag, r, c-1, index);
            flag[r][c] = false;
        }

    }
}
