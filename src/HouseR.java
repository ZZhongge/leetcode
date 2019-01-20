public class HouseR {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[][] store = new int[2][nums.length];
        for(int i=0; i < nums.length; i++) {
            store[0][i] = -1;
            store[1][i] = -1;
        }
        return Math.max(nums[0] + cal(2, nums, 1, store), cal(1, nums, 0, store));
    }

    public int cal(int first, int[] nums, int Flag, int[][] store) {
        if (nums.length <= first) return 0;
        if (nums.length == first+1 && Flag == 1) return 0;
        if (store[Flag][first] == -1) {
            return store[Flag][first] = Math.max(nums[first] + cal(first+2, nums, Flag, store), cal(first+1, nums, Flag, store));
        }
        else {
            return store[Flag][first];
        }
    }

    public int easyrob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[][] store = new int[2][nums.length];
        store[1][0] = 0; store[1][1] = nums[1];
        store[0][0] = nums[0]; store[0][1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < nums.length; i++) {
            store[1][i] = Math.max(nums[i]+store[1][i-2], store[1][i-1]);
            store[0][i] = Math.max(nums[i]+store[0][i-2], store[0][i-1]);
        }
        return Math.max(store[0][nums.length-2], store[1][nums.length-1]);
    }
}
