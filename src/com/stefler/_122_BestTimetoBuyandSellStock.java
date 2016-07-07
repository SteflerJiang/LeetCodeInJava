/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Subscribe to see which companies asked this question
 * */

package com.stefler;

public class _122_BestTimetoBuyandSellStock {
	
	public static int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1])
				res += prices[i] - prices[i - 1]; 
		}
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
