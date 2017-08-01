package BinaryTree;

/**
 * Created by Wang on 2017/4/26.
 */

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LCA {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    LinkedList<TreeNode> pathP;
    LinkedList<TreeNode> pathQ;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }

    public boolean dfs(TreeNode root, TreeNode p, LinkedList<TreeNode> path) {
        if (root == null)
            return false;
        if (root.val == p.val) {

            return true;
        } else {
            if (root.left != null && dfs(root.left, p, path)) {
                // add to path and return
                return true;
            }
            if (root.right != null && dfs(root.right, p, path)) {
                return true;
            }
            return false;
        }
    }


}
