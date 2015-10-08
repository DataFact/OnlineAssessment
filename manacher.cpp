#include <iostream>
#include <string>
#include <cstring>

using namespace std;

void findBMstr(string& str){
	int *p = new int[str.size()+1];
	// memset(p, 0, sizeof(p));

	int radius = 0;
	int pivot = 0;

	for (int i = 1; i < str.size(); i++)
	{
		if (i < radius)
		{
			p[i] = (p[pivot-(i-pivot)] < (radius-i) ? p[pivot-(i-pivot)] : (radius-i));
		}
		else{
			p[i] = 1;
		}

		while(str[i-p[i]] == str[i+p[i]]){
			p[i]++;
		}

		if (i+p[i] > radius)
		{
			radius = i + p[i];
			pivot = i;
		}
	}

	int max = 0;
	int maxPivot;	// 最大的p[i]对应的pivot

	for (int i = 1; i < str.size(); i++)
	{	//找出最大的p[i]
		if (p[i] > max)
		{
			maxPivot = i;
			max = p[i];
		}
	}
	max--; // 因为p[i]初始化为1

	int start = maxPivot - max;
	int end = maxPivot + max;

	for (int i = start; i <= end; i++)
	{
		if (str[i] != '#')
		{
			cout << str[i];
		}
	}

	cout << endl;

	delete p;
}

int main(int argc, char const *argv[])
{
	string str = "abcdcabcbacda";
	string str0;
	str0 += "^#";
	for (int i = 0; i < str.size(); ++i)
	{
		str0 += str[i];
		str0 += "#";
	}
	str0 += "$";

	cout<< str0 << endl;
	findBMstr(str0);
	return 0;
}
