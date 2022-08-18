package com.stefler.cy2022;

import java.util.ArrayList;
import java.util.List;

public class _22GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        return dfs(n, n, "", new ArrayList<>());
    }

    private static List<String> dfs(int left, int right, String s, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(s);
        }

        if (left > 0) {
            dfs(left-1, right, s+"(", res);
        }
        if (right > left) {
            dfs(left, right-1, s+")", res);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
