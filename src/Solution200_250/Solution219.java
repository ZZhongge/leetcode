package Solution200_250;

import java.util.HashMap;

///最好的办法应该是使用set，每次删除之前的
class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> searchmap = new HashMap<>();
        Integer cur;
        for (int i = 0; i < nums.length; i++) {
            if ((cur = searchmap.get(nums[i])) != null) {
                if (i - (int) cur <= k) {
                    return true;
                }
            }
            searchmap.put(nums[i], i);
        }
        return false;
    }
}
