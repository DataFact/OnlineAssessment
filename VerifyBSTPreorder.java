/*
* Given an array of numbers, verify whether it is correct
* preorder traversal sequence of a BST
* using stack, constant space complexity
*/

import java.util.Stack;

public class VerifyBSTPreorder{
	public static boolean verifyPreorder(int[] preorder){
		if (preorder == null || preorder.length<1) {
			return false;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int low = Integer.MIN_VALUE;
		for (int p : preorder ) {
			if(p<low){
				return false;
			}
			// when occur to a larger node, pop all smaller nodes
			while(!stack.isEmpty() && p > stack.peek()){
				low = stack.pop();
			}
			// push smaller nodes to stack
			stack.push(p);
		}
		return true;
	}

	public static void main(String[] args) {
		int[] preorder = {8,3,1,6,4,9,10,14,13};
		System.out.println(verifyPreorder(preorder));
		int[] preorder2 = {3,5,6,2,9,7,8,10,4};
		System.out.println(verifyPreorder(preorder2));
	}
}
