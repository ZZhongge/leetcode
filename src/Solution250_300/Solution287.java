package Solution250_300;

class Solution287 {
    public int findDuplicate(int[] nums) {
        if (nums.length == 0) return 0;
        int fast = nums[nums[0]];
        int slow = nums[0];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }

        fast = nums[0];
        slow = nums[slow];

        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
