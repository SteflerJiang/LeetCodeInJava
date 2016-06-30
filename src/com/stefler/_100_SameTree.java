package com.stefler;

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
