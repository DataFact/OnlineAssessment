/*
* 判断两个byte number是否互为gray code
* 如果两个byte的二进制表示中仅有一位不同，
* 则它们互为gray code
*/

public class GrayCode{
	public static int isGrayCode(byte term1, byte term2){
		byte x = (byte)term1^term2;
		int count = 0;
		while(x!=0){
			x = (byte)(x & (x-1));
			count++;
		}
		return count==1?1:0;
	}
}
