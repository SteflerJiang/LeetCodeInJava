/*
 * Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Subscribe to see which companies asked this question
 * */

package com.stefler.old;

public class _100_SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null)
		{
			if (q == null)
				return true;
			else
				return false;
		}
		if (q == null) return false;
		boolean eq = false;
        if (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
        	eq = true;
        return eq;
    }
}
