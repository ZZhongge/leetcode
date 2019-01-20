package Solution200_250;

///循环当中的运算要尽量的少
class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int tmp = 1;
        result[0] = 1;
        for (int i = 0; i < len; i++) {
            result[i] = tmp;
            tmp = tmp * nums[i];
        }

        tmp = 1;
        for (int j = len-1; j >= 0; j--) {
            result[j] = result[j] * tmp;
            tmp = tmp * nums[j];
        }

        return result;


    }
}
