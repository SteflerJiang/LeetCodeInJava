package com.stefler.old;

public class _357_CountNumberswithUniqueDigits {
	
	public static int countNumbersWithUniqueDigits(int n) {
		if (n == 0) return 1;
        int res = 10;
        int p = 9;
        for(int i = 2; i <= n; i ++) {
        	if (i < 10)
        		p = p * (11 - i);
        	res += p;
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countNumbersWithUniqueDigits(3));
	}

}
