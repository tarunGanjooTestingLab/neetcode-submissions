class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    boolean cond1 = seen.add(board[i][j] + " was seen in row " + i);
                    boolean cond2 = seen.add(board[i][j] + " was seen in col " + j);
                    boolean cond3 = seen.add(board[i][j] + " was seen in box " + i/3 + "-" + j/3);

                    if(cond1 == false || cond2 == false || cond3 == false)
                        return false;
                }
            }
        }

        return true;
    }
}
