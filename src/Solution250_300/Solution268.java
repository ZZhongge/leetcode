package Solution250_300;

///和可以直接用公式计算
class Solution268 {
    public int missingNumber(int[] nums) {
        if (nums.length == 0) return 0;
        int total = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            total += (i+1);
            res += nums[i];
        }
        return total - res;
    }
}
