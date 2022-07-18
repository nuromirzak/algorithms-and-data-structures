// Recursive
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || (p.val != q.val)) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

// Iterative
class Solution {
    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || (p.val != q.val)) {
            return false;
        }

        return true;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (!check(p, q)) return false;

        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();
        pStack.add(p);
        qStack.add(q);

        while (!pStack.isEmpty() && !qStack.isEmpty()) {
            TreeNode pTemp = pStack.pop();
            TreeNode qTemp = qStack.pop();

            if (!check(pTemp, qTemp)) return false;

            if (!check(pTemp.left, qTemp.left)) return false;
            if (pTemp.left != null) {
                pStack.add(pTemp.left);
                qStack.add(qTemp.left);
            }

            if (!check(pTemp.right, qTemp.right)) return false;
            if (pTemp.right != null) {
                pStack.add(pTemp.right);
                qStack.add(qTemp.right);
            }
        }

        return true;
    }
}