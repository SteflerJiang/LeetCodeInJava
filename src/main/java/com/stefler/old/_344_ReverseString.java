/*
	Write a function that takes a string as input and returns the string reversed.
	Example:
	Given s = "hello", return "olleh".
*/

package com.stefler.old;

public class _344_ReverseString {
	public static String reverseString(String s) {
		StringBuilder sb = new StringBuilder(s.length());
		for (int i = s.length() - 1; i >= 0; i--)
		{
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		System.out.println(reverseString("hello"));
	}

}