/*
* 去掉字符串中的元音，返回字符串。
*/

public class RemoveVowels{
	public static String removeVowels(String str){
		if(str==null || str.length()<=0){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		String vowels = "aeiouAEIOU";
		for (int i=0; i<str.length(); i++) {
			if(vowels.indexOf(str.charAt(i)) == -1){
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "abcde asdf wer";
		System.out.println(removeVowels(s));
	}
}
