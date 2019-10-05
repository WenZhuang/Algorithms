package main.leetcode_solutions.stack;

import java.util.Stack;

/**
 * 逆波兰表达式计算
 * @author wenzhuang
 * @date 2019-10-05 19:54
 */
public class T150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++){
            String s = tokens[i];
            if (s.equals("+")){
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(op1 + op2);
            } else if (s.equals("-")){
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(op1 - op2);
            } else if (s.equals("*")){
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(op1 * op2);
            } else if (s.equals("/")){
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(op1 / op2);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}
