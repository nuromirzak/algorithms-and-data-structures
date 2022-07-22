// Bottom-up solution
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }

        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}

// Bottom-up with optimized solution
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int twoStopBefore = cost[0];
        int oneStopBefore = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int currStep = cost[i] + Math.min(twoStopBefore, oneStopBefore);
            twoStopBefore = oneStopBefore;
            oneStopBefore = currStep;
        }

        return Math.min(twoStopBefore, oneStopBefore);
    }
}

// Recursive solution without memoization
// TLE
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        return Math.min(helper(cost, n - 1), helper(cost, n - 2));
    }

    private int helper(int[] cost, int n) {
        if (n <= 1) return cost[n];

        return cost[n] + Math.min(helper(cost, n - 1), helper(cost, n - 2));
    }
}

// Top-down with memoization
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, cost[0]);
        memo.put(1, cost[1]);

        return Math.min(helper(cost, n - 1, memo), helper(cost, n - 2, memo));
    }

    private int helper(int[] cost, int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) return memo.get(n);

        int res = Math.min(helper(cost, n - 1, memo), helper(cost, n - 2, memo)) + cost[n];
        memo.put(n, res);

        return memo.get(n);
    }
}

// https://leetcode.com/problems/min-cost-climbing-stairs/discuss/476388/4-ways-or-Step-by-step-from-Recursion-greater-top-down-DP-greater-bottom-up-DP-greater-fine-tuning
// https://leetcode.com/problems/min-cost-climbing-stairs/discuss/144682/3-Lines-Java-Solution-O(1)-space