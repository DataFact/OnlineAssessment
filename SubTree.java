/*
* 判断T2是否为T1的子树，其中T1有百万个节点，T2有几百个节点
* 这里采用递归方法，从T1的根节点向下递归，判断T2是否在T1的左子树或右子树内
* 虽然时间复杂度为O(mn)，m和n分别为两棵树的节点数
* 但是其空间复杂度却为O(log(m)+log(n))，适用于海量数据
*/

public class SubTree{
	public boolean isSubTree(TreeNode t1, TreeNode t2){
		if (t2 == null) {
			return true;
		}
		if (t1 == null) {
			return false;
		}
		return isSubTree(t1.left, t2) || isSubTree(t1.right, t2);
	}

	//辅助函数，判断t1，t2是否为同一棵树
	public boolean isSameTree(TreeNode t1, TreeNode t2){
		if (t1 == null && t2 == null){
			return true;
		}
		if (t1 == null || t2 == null) {
			return false;
		}
		return t1.val == t2.val && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
	}
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}
