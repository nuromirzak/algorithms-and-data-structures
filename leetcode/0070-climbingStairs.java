// Recursive solution
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

// Top-down solution/Recursion with memoization
class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();

    {
        memo.put(1, 1);
        memo.put(2, 2);
    }

    public int climbStairs(int n) {
        if (memo.containsKey(n)) return memo.get(n);

        memo.put(n, climbStairs(n - 1) + climbStairs(n - 2));

        return memo.get(n);
    }
}

// Bottom-up solution
class Solution {
    public int climbStairs(int n) {
        // If n is 1, then dp[2] will cause IndexOutOfBoundsException
        // Therefore, we need to initialize dp[n + 2]
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

// Bottom-up solution with constant space
class Solution {
    public int climbStairs(int n) {
        int prev = 1;
        if (n <= 1) return prev;
        int curr = 2;

        for (int i = 3; i <= n; i++) {
            int newVal = prev + cur;
            prev = cur;
            cur = newVal;
        }

        return curr;
    }
}

// https://leetcode.com/problems/climbing-stairs/discuss/963994/Java-from-Recursion-to-DP