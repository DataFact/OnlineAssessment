/*
* 字符串仅包含三种括号
* 判断字符串中所有括号是否匹配
*/

import java.util.Stack;

public class ValidParentheses{
	public static boolean isValid(String s){
		if (s == null || s.length()<2) {
			return false;
		}

		Stack<Character> stack = new Stack<Character>();

		for (int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
				stack.push(s.charAt(i));
			}
			else {
				// no left parentheses
				if (stack.size() == 0) {
					return false;
				}
				else if (s.charAt(i) == ')' && stack.pop() != '(') {
					return false;
				}
				else if (s.charAt(i) == ']' && stack.pop() != '[') {
					return false;
				}
				else if (s.charAt(i) == '}' && stack.pop() != '{') {
					return false;
				}
			}
		}
		// if stack is empty, all parentheses are valid
		// otherwise, not valid
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String s1 = "()[]{}";
		String s2 = "([)]";
		System.out.println(isValid(s1));
		System.out.println(isValid(s2));
	}
}
