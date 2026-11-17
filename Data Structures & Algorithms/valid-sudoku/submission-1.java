class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int [9];
        int[] squares = new int [9];

        for (int rowIndex = 0; rowIndex < 9; rowIndex++)
        {
            for (int colIndex = 0; colIndex < 9; colIndex++)
            {
                char c = board[rowIndex][colIndex];
                if (c == '.') continue;

                int squareIndex = (rowIndex / 3) * 3 + (colIndex /3);
                int value = c - 1;
                int mask = 1 << value;


                if ((rows[rowIndex] & mask) > 0 ||
                    (cols[colIndex] & mask) > 0 ||
                    (squares[squareIndex] & mask) > 0)
                {
                    return false;
                }

                rows[rowIndex] |= mask;
                cols[colIndex] |= mask;
                squares[squareIndex] |= mask;
            }
        }

        return true;
    }
}
