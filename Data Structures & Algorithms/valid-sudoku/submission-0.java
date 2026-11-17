class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*
        Core Algorithm:
        - Iterate over the entire Matrix
            - Add each element to a hash table
                - HashMap: Key = ith row, value = jth element of ith row
                - HashMap: Key = ith col, value = jth element of jth col
                - HashMap: Key = 3x3 square, value = element in the square
                    - Key = (ith row / 3, ith col / 3) -> (0, 0), (0,1)...
            - If element == '.', continue
            - If .contains() returns false, return false
        - Otherwise return true
        
        */
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<String, Set<Character>> squareMap = new HashMap<>();

        for (int rowIndex = 0; rowIndex < 9; rowIndex++)
        {
            for (int colIndex = 0; colIndex < 9; colIndex++)
            {
                char c = board[rowIndex][colIndex];
                if (c == '.') continue;

                String squareMapKey = rowIndex/3 + "," + colIndex/3;

                if (rowMap.computeIfAbsent(rowIndex, k -> new HashSet<>()).contains(c) ||
                    colMap.computeIfAbsent(colIndex, k -> new HashSet<>()).contains(c) ||
                    squareMap.computeIfAbsent(squareMapKey, k -> new HashSet<>()).contains(c))
                {
                    return false;
                }

                rowMap.get(rowIndex).add(c);
                colMap.get(colIndex).add(c);
                squareMap.get(squareMapKey).add(c);
            }
        }
        return true;
    }
}
