package Solution200_250;
import BasicDataStructure.*;
import java.util.Stack;

//这道题还有一种二分查找法，每次计算左子树的节点数，直到完全匹配，这样做k比较大的时候会比较快
class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k == 0) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (root.left != null) {
            stack.push(root.left);
            root = root.left;
        }
        return kthhelper(k, stack);
    }

    public int kthhelper(int k, Stack<TreeNode> stack) {
        TreeNode tmp = stack.pop();
        if (k == 1) {
            return tmp.val;
        }
        if (tmp.right != null) {
            stack.push(tmp.right);
            tmp = tmp.right;
            while (tmp.left != null) {
                stack.push(tmp.left);
                tmp = tmp.left;
            }
        }
        return kthhelper(k-1, stack);
    }

    public int kthSmallest1(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k-1-count); // 1 is counted as current node
        }

        return root.val;
    }

    public int countNodes(TreeNode n) {
        if (n == null) return 0;

        return 1 + countNodes(n.left) + countNodes(n.right);
    }
}
