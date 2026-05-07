class Solution {
    public boolean exist(char[][] board, String word) {
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0) && find(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(char[][] board, String word, int index, int i, int j) {
        if(index == word.length()) {return true;}
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] == '#') {
            return false;
        }
        if(board[i][j] != word.charAt(index)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        boolean found = find(board, word, index+1, i+1, j) ||
        find(board, word, index+1, i-1, j) ||
        find(board, word, index+1, i, j+1) ||
        find(board, word, index+1, i, j-1);

        board[i][j] = temp;
        return found;

    }
}
