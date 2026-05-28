class NumMatrix {
    private int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // We make the prefixSum matrix 1 size larger (rows+1, cols+1)
        // This handles the "out of bounds" edge cases for row 0 and col 0 automatically.
        prefixSum = new int[rows + 1][cols + 1];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Formula to build the 2D Prefix Sum:
                // Current = matrix value + Top sum + Left sum - Diagonal sum (double counted)
                prefixSum[r + 1][c + 1] = matrix[r][c] 
                                        + prefixSum[r][c + 1] 
                                        + prefixSum[r + 1][c] 
                                        - prefixSum[r][c];
            }
        }
    }

    public int sumRegion(int r1, int c1, int r2, int c2) {
        // O(1) calculation using our pre-built table
        // We shift indices by +1 because our prefixSum matrix is padded with 0s at the start.
        return prefixSum[r2 + 1][c2 + 1] 
             - prefixSum[r1][c2 + 1] 
             - prefixSum[r2 + 1][c1] 
             + prefixSum[r1][c1];
    }
}