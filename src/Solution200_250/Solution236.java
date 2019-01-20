package Solution200_250;
import BasicDataStructure.TreeNode;
//直接返回node显得干净整洁
class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] res = new TreeNode[1];
        helper(root, p, q, res);
        return res[0];
    }

    public boolean helper(TreeNode root, TreeNode p, TreeNode q, TreeNode[] res) {
        if (root == null) {
            return false;
        }
        boolean right = helper(root.right, p, q, res);
        boolean left = helper(root.left, p, q, res);
        if (right && left) {
            res[0] = root;
        }
        else if (( right || left ) && (root.val == q.val || root.val == p.val)) {
            res[0] = root;
        }
        else if (right || left || root.val == q.val || root.val == p.val) {
            return true;
        }
        return false;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        return getAncestor(root,p,q);
    }

    public TreeNode getAncestor(TreeNode root, TreeNode a, TreeNode b){
        if(root == null)
            return null;

        TreeNode left = getAncestor(root.left, a, b);
        TreeNode right = getAncestor(root.right,a,b);

        if((left != null && right != null) || a.val == root.val || b.val == root.val)
            return root;

        if(left != null)
            return left;
        if(right != null)
            return right;

        return null;
    }
}
