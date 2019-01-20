package Solution200_250;

import java.util.Comparator;
import java.util.TreeSet;

///这道题的本质树结构中的查找，插入（带比较的）
///可能有溢出问题
///floor 和 ceiling 可以获取TreeSet中最接近的两个数
class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Comp comparator = new Comp(k, t);
        TreeSet<node> search = new TreeSet<>(comparator);
        for(int i = 0; i < nums.length; i++) {
            node tmp = new node(i, nums[i]);
            if (search.contains(tmp)) {
                return true;
            }
            else {
                search.add(tmp);
            }
        }
        return false;
    }

    private class node {
        int index;
        int value;
        node(int ind, int val) {
            index = ind;
            value = val;
        }
    }

    private class Comp implements Comparator<node> {
        int t;
        int k;

        Comp(int k, int t){
            this.k = k;
            this.t = t;
        }

        @Override
        public int compare(node n1, node n2){
            if(t >=Math.abs(n1.value - n2.value) && k >= Math.abs(n1.index - n2.index)){
                return 0;
            }
            else if(n1.value > n2.value){
                return -1;
            }
            else{
                return 1;
            }
        }
    }
}
