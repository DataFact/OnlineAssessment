/*
* 求最大回文子串
* 比如"abcb"的最大回文子串为"bcb"
* 这里采用动态规划解题，时间复杂度为O(n^2)
* 更好的方法为manacher算法，时间复杂度为O(n)，但过于复杂，一时无法理解
*/

public class LongestPalindrome{
	public static String longestPalindrome(String s){
		if(s.length()==0){
			return null;
		}
		int len = s.length();
		boolean[][] map = new boolean[len][len];
		int max_len = 1;
		int index = 0;
		for (int i=0; i<len; i++) {
			map[i][i] = true;
			for (int j=0; j<i; j++) {
				if(s.charAt(i) == s.charAt(j) && (i-j<2 || map[j+1][i-1])){
					map[j][i] = true;
					if((i-j+1) > max_len){
						index = j;
						max_len = i-j+1;
					}
				}
			}
		}
		return s.substring(index, index+max_len);
	}

	public static void main(String[] args) {
		String s = "abcbbcb";
		System.out.println(longestPalindrome(s));
	}
}

