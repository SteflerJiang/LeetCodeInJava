package com.stefler;

public class _171_ExcelSheetColumnNumber {

	public static int titleToNumber(String s) {
		int res = 0;
		int tmp = 1;
		int l = s.length();
		for(int i = 1; i <= l; i ++)
		{
			char c = s.charAt(l-i);
			res = res + (c - 'A' + 1) * tmp;
			tmp *=26;
		}
		return res;
    }
	public static void main(String[] args) {
		System.out.println(titleToNumber("AB"));
	}

}
