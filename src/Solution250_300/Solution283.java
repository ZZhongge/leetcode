package Solution250_300;

///除了最后操作以外，还可以在中途操作
class Solution283 {
    public void moveZeroes(int[] nums) {
        int count = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[start] = nums[i];
                start += 1;
            }
            else {
                count += 1;
            }
        }
        int tail = nums.length-1;

        for (int j = 0; j < count; j++) {
            nums[tail-j] = 0;
        }
    }
}
