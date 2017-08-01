/**
 * Created by Wang on 2017/4/16.
 */
/**
 * Definition for a binary tree node.
 * private class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class sol_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode p = root;
        TreeNode par = null;
        // search
        while(null != p){ // || null != p.left && null != p.right) {
            if (key > p.val) {
                par = p;
                p = p.right;
            } else if (key < p.val) {
                par = p;
                p = p.left;
            } else {
                break;
            }
        }
        if (null == p){
            // No node have the value, no need to remove
            return root;
        }
        // Removing root node
        if (p == root) {
            if (null == root.left) {
                return root.right;
            } else if (null == root.right){
                return root.left;
            }
        }

        if (p.left == null) {
            if (p.val > par.val)
                par.right = p.right;
            else
                par.left = p.right;
        } else if (p.right == null) {
            if (p.val > par.val)
                par.right = p.left;
            else
                par.left = p.left;
        } else {
            TreeNode maxNode = p.left;
            TreeNode prev = p;
            // find the max value from child tree p.left
            while (null != maxNode.right) {
                prev = maxNode;
                maxNode = maxNode.right;
            }
            p.val = maxNode.val;
            if (prev == p) {
                p.left = maxNode.left;
            } else {
                prev.right = maxNode.left;
            }
        }

        return root;
    }

//    // Recursive version
//    public TreeNode deleteNode(TreeNode root, int key) {
//        if (null == root) {
//            return null;
//        } else if (key > root.val) {
//            root.right = deleteNode(root.right, key);
//        } else if (key < root.val) {
//            root.left = deleteNode(root.left, key);
//        } else {
//            if (root.left == null)
//                return root.right;
//            if (root.right == null)
//                return root.left;
//            TreeNode maxNode = root.left;
//            TreeNode prev = root;
//            // find the max value from child tree p.left
//            while (null != maxNode.right) {
//                prev = maxNode;
//                maxNode = maxNode.right;
//            }
//            root.val = maxNode.val;
//            if (prev == root) {
//                root.left = maxNode.left;
//            } else {
//                prev.right = maxNode.left;
//            }
//        }
//        return root;
//    }
}