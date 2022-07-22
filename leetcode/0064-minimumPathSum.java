// Recursive relation
// dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]

// Recursive solution
class Solution {
    public int minPathSum(int[][] grid) {
        return helper(grid, grid.length - 1, grid[0].length - 1);
    }

    private int helper(int[][] grid, int i, int j) {
        if (i == 0 && j == 0) return grid[0][0];

        int fromTop = i > 0 ? helper(grid, i - 1, j) : Integer.MAX_VALUE;
        int fromLeft = j > 0 ? helper(grid, i, j - 1) : Integer.MAX_VALUE;

        return Math.min(fromLeft, fromTop) + grid[i][j];
    }
}

// Top-down with memoization
class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;

        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                dp[i][j] = -1;

        dp[0][0] = grid[0][0];

        return helper(grid, row - 1, col - 1, dp);
    }

    private int helper(int[][] grid, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) return dp[i][j];

        int fromTop = i > 0 ? helper(grid, i - 1, j, dp) : Integer.MAX_VALUE;
        int fromLeft = j > 0 ? helper(grid, i, j - 1, dp) : Integer.MAX_VALUE;

        dp[i][j] = Math.min(fromLeft, fromTop) + grid[i][j];

        return dp[i][j];
    }
}

// Bottom-up solution
class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;

        int[][] dp = new int[row][col];

        dp[0][0] = grid[0][0];

        // Filling the top row
        for (int i = 1; i < col; i++) dp[0][i] = dp[0][i - 1] + grid[0][i];

        // Filling the top row
        for (int i = 1; i < row; i++) dp[i][0] = dp[i - 1][0] + grid[i][0];

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[row - 1][col - 1];
    }
}