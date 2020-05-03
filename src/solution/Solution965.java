package solution;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

//递归
public class Solution965 {
    public boolean isUnivalTree(TreeNode root) {
        return (root.left == null || root.left.val == root.val && isUnivalTree(root.left)) && (root.right == null || root.right.val == root.val && isUnivalTree(root.right));
    }
}

// dfs
class DfsSolution {
    List<Integer> vals;
    public boolean isUnivalTree(TreeNode root) {
        vals = new LinkedList();
        dfs(root);
        int val = root.val;
        for (Integer integer : vals) {
            if (integer != root.val) {
                return false;
            }
        }
        return true;
    }
    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        dfs(root.left);
        vals.add(root.val);
        dfs(root.right);
    }
}

// bfs
class BfsSolution {

    List<Integer> vals;

    public boolean isUnivalTree(TreeNode root) {
        vals = new LinkedList();
        bfs(root);
        int val = root.val;
        for (Integer integer : vals) {
            if (integer != root.val) {
                return false;
            }
        }
        return true;
    }

    private void bfs(TreeNode root) {
        TreeNode treeNode = root;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            treeNode = queue.poll();
            vals.add(treeNode.val);
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }
    }
}

