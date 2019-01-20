package Solution250_300;

class Solution279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 0; i < dp.length; i++)
            dp[i] = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i ++){
            int sqrt = (int)Math.sqrt(i);
            if(sqrt*sqrt == i)
            {
                dp[i] = 1;
                continue;
            }
            for(int k = 1; k <= sqrt; k++){
                dp[i] = Math.min(dp[i],dp[i - k* k] + 1);

            }
        }
        return dp[n];
    }

    ///数学证明法
    public int numSquares1(int n){
        while(n % 4 == 0) n /= 4;
        if(n % 8 == 7) return 4;
        for(int a = 0; a * a <= n; a++){
            int b = (int)Math.sqrt(n - a * a);
            if(a * a + b * b == n){
                if(a != 0 && b != 0){
                    return 2;
                }else{
                    return 1;
                }
            }
        }
        return 3;
    }
}
