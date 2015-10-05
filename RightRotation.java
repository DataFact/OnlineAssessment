/*
* 判断一个字符串是不是另一个字符串的rotation
* 比如"waterbottle"是"erbottlewat"的rotation
* 一定要注意检查两个字符串长度是否相等，若不等则不是rotation
* 将s1与自己连接得到新的字符串，判断s2是不是新字符串的子串
* 若是子串，则是s1的rotation。
*/

public class RightRotation{
	public static boolean checkRightRotation(String s1, String s2){
		if(s1.length() != s2.length() || s1.length() <= 0){
			return false;
		}
		String s = s1+s2;
		if(s.contains(s2)){
			return true;
		}
		else{
			return false;
		}
	}

	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		System.out.println(checkRightRotation(s1,s2));
	}
}
