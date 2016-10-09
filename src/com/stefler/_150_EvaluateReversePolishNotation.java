/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
Subscribe to see which companies asked this question
 */

package com.stefler;

import java.util.Stack;

public class _150_EvaluateReversePolishNotation {

	public static int evalRPN(String[] tokens) {
		Stack<Integer> ints = new Stack<>();
		for (String s : tokens) {
			if (s == "+") {
				int a = ints.pop();
				int b = ints.pop();
				ints.push(a + b);
			}
			else if (s == "-") {
				int a = ints.pop();
				int b = ints.pop();
				ints.push(b - a);
			}
			else if (s == "*") {
				int a = ints.pop();
				int b = ints.pop();
				ints.push(a * b);
			}
			else if (s == "/") {
				int a = ints.pop();
				int b = ints.pop();
				ints.push(b / a);
			}
			else
				ints.push(Integer.parseInt(s));
		}
        return ints.pop();
    }

	public static void main(String[] args) {
		String[] token = { "0", "3", "/" };
		System.out.println(evalRPN(token));
	}

}
