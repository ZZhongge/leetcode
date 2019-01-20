package Solution200_250;

import java.util.Stack;

//去除空格拿到下个数是关键，需要全局的遍历临时变量i
//stack不重要，关键是下一个数字
class Solution227 {
        int i = 0;
        public int calculate(String s) {
            final Stack<Integer> stack = new Stack<>();
            stack.push(nextNum(s));

            while (i < s.length()) {
                char c = s.charAt(i++);
                if (c == '+') stack.push(nextNum(s));
                else if (c == '-') stack.push(-nextNum(s));
                else if (c == '*') stack.push(stack.pop() * nextNum(s));
                else if (c == '/') stack.push(stack.pop() / nextNum(s));
            }

            int expression = 0;
            while (!stack.isEmpty()) expression += stack.pop();
            return expression;
        }

        private int nextNum(String s) {
            int num = 0;

            while (i < s.length() && s.charAt(i) == ' ') i++;
            while (i < s.length() && Character.isDigit(s.charAt(i))) num = num * 10 + (s.charAt(i++) - '0');
            while (i < s.length() && s.charAt(i) == ' ') i++;

            return num;
        }
}
