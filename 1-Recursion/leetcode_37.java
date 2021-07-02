// opti code
class Solution {
    public boolean issafeToPlaceNumber(char[][] board, int row, int col, int num){
        int n = board.length, m = board[0].length;

        //row
        for(int j = 0; j < m ; j++)
            if((board[row][j] - '0') == num)
                return false;

        //column
        for(int i = 0; i < n ; i++)
            if((board[i][col] - '0') == num)
                return false;

        //matrix
        row = (row / 3) * 3;
        col = (col / 3) * 3;
        for(int i = 0; i < 3 ; i++)
            for(int j = 0; j < 3 ; j++)
                if((board[i + row][j + col] - '0') == num)  //shiftng
                    return false;

            return true;
    }

    public boolean sudokuSolver(char[][] board, ArrayList<Integer> IDX,int idx) {
        if(idx == IDX.size())   return true;

        int r = IDX.get(idx) / 9;
        int c = IDX.get(idx) % 9;

        for(int num = 1; num <= 9; num++) {
            if(issafeToPlaceNumber(board,r,c,num)) {
                board[r][c] = (char) (num + '0');
                if(sudokuSolver(board,IDX, idx+1))
                    return true;
                board[r][c] = '.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        ArrayList<Integer> IDX = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') {
                    IDX.add( i * 9 + j);
                }
            }
        }
        sudokuSolver(board,IDX,0);
    }
}

////////////////////////////////////////////////////

// class Solution {
//     public boolean issafeToPlaceNumber(char[][] board, int row, int col, int num){
//         int n = board.length, m = board[0].length;

//         //row
//         for(int j = 0; j < m ; j++)
//             if((board[row][j] - '0') == num)
//                 return false;

//         //column
//         for(int i = 0; i < n ; i++)
//             if((board[i][col] - '0') == num)
//                 return false;

//         //matrix
//         row = (row / 3) * 3;
//         col = (col / 3) * 3;
//         for(int i = 0; i < 3 ; i++)
//             for(int j = 0; j < 3 ; j++)
//                 if((board[i + row][j + col] - '0') == num)  //shiftng
//                     return false;

//             return true;
//     }

//     public boolean sudokuSolver(char[][] board, int idx) {
//         if(idx == 81)   return true;

//         int r = idx/9;
//         int c = idx%9;

//         if(board[r][c] != '.'){
//             if(sudokuSolver(board, idx+1))
//                 return true;
//         } else {
//             for(int num = 1; num <= 9; num++) {
//                 if(issafeToPlaceNumber(board,r,c,num)) {
//                     board[r][c] = (char) (num + '0');
//                     if(sudokuSolver(board, idx+1))
//                         return true;
//                     board[r][c] = '.';
//                 }
//             }
//         }
//         return false;
//     }
//     public void solveSudoku(char[][] board) {
//         sudokuSolver(board,0);
//     }
// }