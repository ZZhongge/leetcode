package Solution200_250;
import BasicDataStructure.*;
///探明层数以后，用二分查找，二分查找对于一个点的左右特征固定情况很有效（即根据探查到的点，就可以知道往那边寻找）
///暴力dfs快很多。。。。。
class Solution222 {
    int res = 0;
    public int countNodes(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        if (root.val < 0)
            return;
        root.val = -1;
        res ++;
        dfs(root.left);
        dfs(root.right);
    }
}
