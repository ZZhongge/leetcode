package Solution250_300;

class Solution260 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int i : nums) {
            diff ^= i;
        }

        ///取得最后一位，即不相同的那个比特位
        diff &= -diff;

        int[] res = new int[2];
        for (int i : nums) {
            if ((diff & i) == 0) {
                res[0] ^= i;
            }
            else {
                res[1] ^= i;
            }
        }
        return res;
    }
}
