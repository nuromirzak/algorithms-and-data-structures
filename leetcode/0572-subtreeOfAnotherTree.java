// Recursively check if the two trees are identical.
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;

        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || (p.val != q.val)) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

// Building a string from the tree, and compare
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String s1 = serialize(root);
        String s2 = serialize(subRoot);

        return s1.contains(s2);
    }

    private String serialize(TreeNode root) {
        if (root == null) return "#";
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(root.val);
        sb.append(",");
        sb.append(serialize(root.left));
        sb.append(",");
        sb.append(serialize(root.right));
        sb.append("}");
        return sb.toString();
    }
}