import Solution250_300.Solution275;

import java.util.*;
import java.lang.Math;

public class Leetcode {
    //这个方法的运算量太大了，还是bool数组最简单
    static public int countPrime(int n){
        if (n < 3) { return 0; }
        ArrayList<Integer> Prime = new ArrayList<>();
        Prime.add(2);
        int result = 1, rest;
        double tmp;
        for(int i = 3; i < n; i++){
            tmp = Math.sqrt(i);
            for (int x:Prime) {
                if (x > tmp){
                    result += 1;
                    Prime.add(i);
                    break;
                }
                rest = i%x;
                if (rest == 0){
                    break;
                }
            }
        }
        return result;
    }

    //遍历所有数，将他们相乘的标记为非质数
    static public int countPrime1(int n){
        if (n < 3) return 0;
        boolean[] isPrime = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++){
            if (!isPrime[i]){
                count++;
            }
            for (int j = 2; i * j < n; j++){
                isPrime[i*j] = true;
            }
        }
        return count;
    }

    //iterator method
    static public ListNode removeElements(ListNode head, int val) {
        ListNode First = new ListNode(0);
        First.next = head;
        head = First;
        while (First.next != null){
            if (First.next.val == val){
                First.next = First.next.next;
            }
            else{
                First = First.next;
            }
        }
        return head.next;
    }

    //recursive method, 链表比较适合递归式，减少指针的使用
    static public ListNode removeElements1(ListNode head, int val) {
        if (head == null){ return null; }
        if (head.val == val){
            return removeElements1(head.next,val);
        }
        else{
            head.next = removeElements1(head.next, val);
            return head;
        }
    }

    static public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> stash = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            if (stash.containsKey(s.charAt(i)) && stash.get(s.charAt(i)) != t.charAt(i)){
                return false;
            }
            else if (!stash.containsKey(s.charAt(i))){
                if (stash.containsValue(t.charAt(i))){
                    return false;
                }
                stash.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

    //iterator
    static public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode First = new ListNode(0);
        ListNode tmp = First.next;
        while(head != null){
            First.next = head;
            head = head.next;
            First.next.next = tmp;
            tmp = First.next;
        }
        return First.next;
    }

    //recursive
    static public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    //邻接矩阵法
    static public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        //统计
        for (int[] tmp:prerequisites) {
            int prereq = tmp[1];
            int ready = tmp[0];
            indegree[ready]++;
            matrix[prereq][ready] = 1;
        }

        //初始化入度为0的队列,以及统计值
        int count = 0;
        LinkedList<Integer> ProcessQueue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if (indegree[i] == 0) ProcessQueue.offer(i);
        }

        //迭代处理队列中的节点
        while(!ProcessQueue.isEmpty()){
            int course = ProcessQueue.poll();
            count++;
            for(int j = 0; j < numCourses; j++){
                if (matrix[course][j] == 1){
                    if (--indegree[j] == 0){
                        ProcessQueue.offer(j);
                    }
                }
            }
        }

        return count == numCourses;
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int minLength = Integer.MAX_VALUE, head = 0, tail = 0, sum = 0;
        while(tail < nums.length) {
            sum += nums[tail];
            while (sum >= s) {
                minLength = Math.min(minLength, tail-head+1);
                sum -= nums[head];
                head++;
            }
            tail++;
        }
        return minLength == Integer.MAX_VALUE? 0 : minLength;
    }

    //quickselect也可以
    static public int findKthLargest(int[] nums, int k) {
        int[] res = new int[k];
        System.arraycopy(nums, 0, res, 0, k);
        for(int i = res.length/2; i >= 0; i--) {
            percolate(res, i);
        }

        for(int j = k; j < nums.length; j++) {
            if (nums[j] > res[0]) {
                res[0] = nums[j];
                percolate(res, 0);
            }
        }
        return res[0];
    }

    static public void percolate(int[] nums, int pos) {
        int child;
        int length = nums.length;
        int tmp;
        for(;pos * 2 <= length-2; pos = child) {
            tmp = nums[pos];
            child = pos * 2 + 1;
            if (child != length-1 && nums[child] > nums[child+1]) {
                child++;
            }
            if (nums[pos] > nums[child]) {
                nums[pos] = nums[child];
                nums[child] = tmp;
            }
            else {
                break;
            }
        }
    }

    static public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        combinationSum3helper(k, n, new ArrayList<>(), result);
        return result;
    }

    static public void combinationSum3helper(int k, int n, ArrayList<Integer> tmp, List<List<Integer>> res) {
        if (k == 0 && n == 0) {
            res.add(tmp);
            return;
        }
        int initial = tmp.size() == 0 ? 1:tmp.get(tmp.size() - 1) + 1;
        int limit = (initial + initial + k - 1) * k / 2;
        while(initial < 10 && limit <= n) {
            ArrayList<Integer> cur_tmp = new ArrayList<>(tmp);
            cur_tmp.add(initial);
            combinationSum3helper(k - 1, n - initial, cur_tmp, res);
            limit += k;
            initial++;
        }
    }

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        char[][] s = new char[][]{{'1','0','1'}, {'0','1','1'}, {'1','1','1'}};
        Solution275 zz = new Solution275();
//        TreeNode x = new TreeNode(3);
//        TreeNode y = new TreeNode(1);
//        TreeNode z = new TreeNode(5);
//        x.left = y;
//        x.right = z;
        int zx = zz.hIndex(new int[]{3});
        long endTime = System.currentTimeMillis();
        System.out.println("结果:" + zx + "\n" + "运行时间："+ (endTime - startTime) + "ms");
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class MyQueue232 {
    Stack s1;
    Stack s2;
    public MyQueue232() {
        s1 = new Stack();
        s2 = new Stack();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        peek();
        return (int)s2.pop();
    }

    public int peek() {
        if(s2.empty())
            while(!s1.empty())
                s2.push(s1.pop());
        return (int)s2.peek();
    }

    public boolean empty() {
        return s1.empty()&&s2.empty();
    }
}

///Solution284
///如果iterator本身还有null，需要有额外的字段来检测
class PeekingIterator implements Iterator<Integer> {
    Integer next = null;
    Iterator<Integer> inner_iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        inner_iterator = iterator;
        if (inner_iterator.hasNext()) {
            next = inner_iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = next;
        next = inner_iterator.hasNext() ? inner_iterator.next() : null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}















