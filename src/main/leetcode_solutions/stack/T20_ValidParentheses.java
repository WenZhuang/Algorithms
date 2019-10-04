package main.leetcode_solutions.stack;

import java.util.Stack;

/**
 * 合法括号：使用栈进行匹配
 * @author wenzhuang
 * @date 2019-10-04 20:58
 */

/**
 * 此题有个比较tricky的做法
 * 正常做法：遍历碰到左括号，进栈；遇到右括号，检查是否匹配，匹配则出栈，否则匹配失败
 * tricky解：遍历碰到左括号，将对应的右括号进栈；遇到右括号，只需检查栈顶元素是否等于当前括号即可
 * 以下为tricky解
 */
public class T20_ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        //判断如果字符数是奇数个，直接返回不匹配
        if ((s.length() & 1) == 1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '('){
                stack.push(')');
            } else if (c == '['){
                stack.push(']');
            } else if (c == '{'){
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
