

package com.stefler.old;

public class _338_CountingBits {

	public int[] countBits(int num) {
		int[] res = new int[num+1];
		for (int i = 0; i < res.length-1; i = i + 2) {
			res[i] = countBit(i);
			res[i+1] = res[i]+1;
		}
		if (num % 2 == 0)
			res[num] = countBit(num);
        return res;
    }
	
	public static int countBit(int num) {
		int n = 0;
		while (num != 0) {
			num = num & (num-1);
			++n;
		}
		return n;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " count bit = " + countBit(i));
		}
//		System.out.println(countBit(4));
	}

}
