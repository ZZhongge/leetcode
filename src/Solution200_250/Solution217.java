package Solution200_250;

import java.util.HashSet;

class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> x = new HashSet<>();
        for (int i: nums) {
            if (!x.add(i)) {
                return true;
            }
        }
        return false;
    }
}
