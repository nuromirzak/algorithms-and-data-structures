// Recursive
class Solution {
    private int ans = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return ans;
    }

    private void dfs(TreeNode root, int max) {
        if (root == null) return;
        if (root.val >= max) ans++;
        dfs(root.left, Math.max(max, root.val));
        dfs(root.right, Math.max(max, root.val));
    }
}