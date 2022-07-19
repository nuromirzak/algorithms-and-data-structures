// Iterative solution
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }

        return -1;
    }
}

// Recursive solution
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res.get(k - 1);
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }
}