// Recursive, top-down
class Solution {
    public int rob(int[] nums) {
        return rob(nums, nums.length - 1);
    }

    private int rob(int[] nums, int n) {
        if (n < 0) return 0;

        return Math.max(rob(nums, n - 2) + nums[n], rob(nums, n - 1));
    }
}

// Top-down with memoization
class Solution {
    public int rob(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<>();

        return rob(nums, nums.length - 1, memo);
    }

    private int rob(int[] nums, int n, Map<Integer, Integer> memo) {
        if (n < 0) return 0;
        if (memo.containsKey(n)) return memo.get(n);

        memo.put(n, Math.max(rob(nums, n - 2, memo) + nums[n], rob(nums, n - 1, memo)));

        return memo.get(n);
    }
}

// Bottom-up
class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length + 1];
        memo[0] = 0; memo[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            memo[i + 1] = Math.max(memo[i], memo[i - 1] + nums[i]);
        }

        return memo[nums.length];
    }
}

// Bottom-up with optimization
class Solution {
    public int rob(int[] nums) {
        int twoHouseBefore = 0;
        int oneHouseBefore = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int currHouse = Math.max(twoHouseBefore + nums[i], oneHouseBefore);
            twoHouseBefore = oneHouseBefore;
            oneHouseBefore = currHouse;
        }

        return oneHouseBefore;
    }
}