//用manacher算法找最大回文子串

public class Manacher{

	public static String longestPalindrome(String s){
		String ss = preProcess(s);
		int pivot = 0;
		int boundary = 0;
		int[] p = new int[ss.length()];
		// p[0] = 0;

		// 从第二个元素开始(也就是从第一个#开始)循环：计算每一个p[i]的值
		for (int i=1; i<ss.length()-1; i++) {
			// 算出初始时p[i]的值
			if (i >= boundary) {
				p[i] = 0;
			}
			else {
				p[i] = Math.min(p[pivot-(i-pivot)], boundary-i);
			}

			// 以i为中心，现有对称区域为[i-p[i], i+p[i]]，然后向左右扩展
			while(ss.charAt(i-p[i]-1) == ss.charAt(i+p[i]+1)){
				p[i]++;
			}

			// 如果找到新的对称区域，重置pivot和boundary
			if(i+p[i] > boundary){
				pivot = i;
				boundary = i+p[i];
			}

		}

		int max_len = 0;
		int center = 0;

		// 找出最大的p[i]
		for (int i=1; i<p.length-1; i++) {
			if (p[i] > max_len) {
				max_len = p[i];
				center = i;
			}
		}

		return s.substring((center-1-max_len)/2, (center-1+max_len)/2);
	}

    public static String preProcess(String s){
		StringBuffer sb = new StringBuffer();
		sb.append("^");
		for (int i=0; i<s.length(); i++) {
			sb.append("#");
			sb.append(s.charAt(i));
		}
		sb.append("#$");
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "abcbabcac";
		System.out.println(longestPalindrome(s));
	}
}
