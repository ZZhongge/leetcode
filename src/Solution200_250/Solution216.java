package Solution200_250;

import java.util.ArrayList;
import java.util.List;

///开始以为是无限，现在不是无限的话，通过数组限定范围，传递counter减少运算
// 传递tmp但是不是复制，而是每次都在这个tmp上操作，写入时复制
class Solution216 {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<List<Integer>>();
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        helper(numbers, k, n, 0, new ArrayList<>(), 0);
        return result;
    }

    private void helper(int[] numbers, int k, int target, int index, List<Integer> list, int counter) {
        if(counter > k) {
            return;
        }
        if(target == 0) {
            if(counter == k) result.add(new ArrayList<>(list));
            return;
        }
        for(int i=index; i<numbers.length; i++) {
            if(target < numbers[i]) {
                break;
            }
            list.add(numbers[i]);
            helper(numbers, k, target-numbers[i], i+1, list, counter+1);
            list.remove(list.size()-1);
        }
    }
}
