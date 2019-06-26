/*
 * Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Subscribe to see which companies asked this question
 * */

package com.stefler.old;

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
