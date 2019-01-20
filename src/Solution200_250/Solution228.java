package Solution200_250;

import java.util.ArrayList;
import java.util.List;

class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        ArrayList<String> res = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();
        String row = "->";
        for (int i = 1; i < nums.length; i++) {
            int start = i-1;

            while (i < nums.length && nums[i] - nums[i-1] == 1) {
                i++;
            }

            if (i - start > 1) {
                res.add(tmp.append(String.valueOf(nums[start])).append(row).append(nums[i-1]).toString());
            }
            else{
                res.add(tmp.append(String.valueOf(nums[start])).toString());
            }
            tmp = new StringBuilder();
        }
        return res;
    }
}
