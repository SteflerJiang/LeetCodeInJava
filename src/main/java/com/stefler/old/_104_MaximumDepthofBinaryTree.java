/*
	Given a binary tree, find its maximum depth.
	
	The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/

package com.stefler.old;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }
}

public class _104_MaximumDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
    	return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
