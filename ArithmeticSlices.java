/*
* Arithmetic sequence 等差数列
* 计算一个数组中等差数列的个数
* 等差数列最少由3个数组成
* 一定要考虑最后的个数是否溢出
*/

public class ArithmeticSlices{
	public static int numOfArithmeticSlices(int[] array){
		int n = array.length;
		if(n < 3){
			return 0;
		}

		int numOfSlices = 0;
		int start = 0;

		while(start < n-2){
			int end = start+1;	//end of a slice
			int diff = array[end]-array[start];	//different of the arithmetic

			//extend the slice until artihmetic condition fails
			//判断后一个数是否仍然是等差数列中的数，所以用后一个数减去当前数
			while(end<n-1 && array[end+1]-array[end]==diff){
				end++;
			}

			int lenOfSlice = end-start+1;

			if(lenOfSlice >= 3){
				// lenOfSlice==3时，等差数列有1个
				// lenOfSlice==4时，等差数列有3个
				// lenOfSlice==5时，等差数列有6个
				// lenOfSlice==n(n>3)时，等差数列有(n-1)(n-2)/2个
				numOfSlices = numOfSlices + (lenOfSlice-2)*(lenOfSlice-1)/2;

			}

			start = end;

		}

		return (numOfSlices>1000000000)?-1:numOfSlices;

	}

	public static void main(String[] args) {
		int[] array = {-1,1,3,3,3,2,1,0};
		System.out.println(numOfArithmeticSlices(array));
	}
}
