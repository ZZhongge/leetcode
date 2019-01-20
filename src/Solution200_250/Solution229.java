package Solution200_250;

import java.util.ArrayList;
import java.util.List;

///摩尔投票算法，统计大于50%的人
///n/3即最多两个人，采用两人摩尔统计算法
class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        int candidate1=-1, candidate2=-1, count1=0, count2=0;
        for(int n:nums) {
            if (candidate1 == n) {
                count1++;
            }
            else if (candidate2 == n) {
                count2++;
            }
            else if (count1 == 0) {
                candidate1 = n;
                count1++;
            }
            else if (count2 == 0) {
                candidate2 = n;
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i: nums) {
            if (candidate1 == i) {
                count1++;
            }
            else if(candidate2 == i) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            res.add(candidate1);
        }
        if (count2 > nums.length /3) {
            res.add(candidate2);
        }
        return res;
    }
}
