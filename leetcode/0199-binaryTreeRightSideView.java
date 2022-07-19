// BFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode temp = null;

            for (int i = 0; i < size; i++) {
                temp = queue.poll();
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            // Adding the last node of the level to the result
            res.add(temp.val);
        }

        return res;
    }
}

// Recursive
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<Integer> list, int depth) {
        if (root == null) {
            return;
        }
        if (depth == list.size()) list.add(root.val);
        helper(root.right, list, depth + 1);
        helper(root.left, list, depth + 1);
    }
}