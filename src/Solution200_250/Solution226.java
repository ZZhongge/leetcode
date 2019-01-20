package Solution200_250;
import BasicDataStructure.*;
class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode tmp = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = tmp;
        return root;
    }
}
