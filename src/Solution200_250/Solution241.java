package Solution200_250;

import java.util.ArrayList;
import java.util.List;

class Solution241 {
    List[][] dp;
    public List<Integer> diffWaysToCompute(String input) {
        int len = input.length();
        if (len == 0) return new ArrayList<Integer>();
        dp = new List[len][len];

        return evaluate(input.toCharArray(), 0, len);
    }

    public List<Integer> evaluate(char[] str, int start, int end) {
        if (dp[start][end - 1] != null) return dp[start][end - 1];

        ArrayList<Integer> res = new ArrayList<>();
        boolean pureInt = true;
        for (int i = start; i < end; i++) {
            char s = str[i];
            if (s == '+' || s == '-' || s == '*') {
                pureInt = false;

                List<Integer> left = evaluate(str, start, i);
                List<Integer> right = evaluate(str, i+1, end);

                for (int n : left) {
                    for (int m : right) {
                        switch (s) {
                            case '+':
                                res.add(n + m);
                                break;
                            case '-':
                                res.add(n - m);
                                break;
                            case '*':
                                res.add(n * m);
                                break;
                        }
                    }
                }
            }
        }
        if (pureInt) {
            int v = Integer.valueOf(new String(str, start, end-start));
            res.add(v);
        }
        dp[start][end-1] = res;
        return res;
    }
}
