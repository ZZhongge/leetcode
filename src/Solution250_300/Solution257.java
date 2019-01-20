package Solution250_300;

import java.util.ArrayList;
import java.util.List;
import BasicDataStructure.TreeNode;


///构造空字符串为了保证之后的操作一致性，采用new String("")
class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        String tmp = new String();
        helper(root, tmp, res);
        return res;
    }

    public void helper(TreeNode root, String tmp, ArrayList<String> res) {
        if (root == null) {
            return;
        }

        if (tmp.length() != 0) {
            tmp = tmp + "->" + String.valueOf(root.val);
        }
        else {
            tmp = String.valueOf(root.val);
        }

        if (root.right == null && root.left == null) {
            res.add(tmp);
            return;
        }

        helper(root.left, tmp, res);
        helper(root.right, tmp, res);
    }

    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> strList = new ArrayList<String>();
        buildPath(root,strList,new String(""));
        return strList;
    }
    public void buildPath(TreeNode node, List<String> strList, String path){
        if(node == null){
            return;
        }
        path += node.val;
        if(node.left == null && node.right == null){
            strList.add(path);
        }
        else{
            path += "->";
            buildPath(node.left,strList,path);
            buildPath(node.right,strList,path);
        }

    }
}















