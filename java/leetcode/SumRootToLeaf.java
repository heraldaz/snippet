package oj;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeaf {
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) { val = x; }
	}
	
	class TreeNodeAndSum {
		public TreeNodeAndSum(TreeNode n, int sum) {
			this.node = n;
			this.sum = sum;
		}		
		TreeNode node;
		int sum;
	}	
	 	
	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		
		List<TreeNodeAndSum> nq = new ArrayList<TreeNodeAndSum>();		
		int total = 0;		
		nq.add(new TreeNodeAndSum(root, root.val));
		while (!nq.isEmpty()) {
			TreeNodeAndSum ns = nq.get(0);
			nq.remove(0);
			
			if (ns.node.left == null && ns.node.right == null) {
				total += ns.sum;
			} else {
				if (ns.node.left != null) {
					nq.add(new TreeNodeAndSum(ns.node.left, ns.sum * 10 + ns.node.left.val));
				}
				if (ns.node.right != null) {
					nq.add(new TreeNodeAndSum(ns.node.right, ns.sum * 10 + ns.node.right.val));
				}				
			}
		}		
		return total;
    }	

	public static void main(String[] args) {
		SumRootToLeaf s = new SumRootToLeaf();
		
		SumRootToLeaf.TreeNode root = new SumRootToLeaf.TreeNode(0);
		
		System.out.println(s.sumNumbers(root));
	}
}
