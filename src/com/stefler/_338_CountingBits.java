/*
	Given a non negative integer number num. For every numbers i in the range 0 ¡Ü i ¡Ü num calculate the number of 1's in their binary representation and return them as an array.
	
	Example:
	For num = 5 you should return [0,1,1,2,1,2].
	
	Follow up:
	
	It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
	Space complexity should be O(n).
	Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
*/

package com.stefler;

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
