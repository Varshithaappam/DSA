import java.util.*;

public class PostfixEvaluator {

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int performOperation(int op1, int op2, char c) {
        switch (c) {
            case '+': return op1 + op2;
            case '-': return op1 - op2;
            case '*': return op1 * op2;
            case '/':
                if (op2 == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return op1 / op2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    public static int evaluatePostfixExp(String s) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push(ch - '0');  // Convert char to int
            } else if (isOperator(ch)) {
                if (stack.size() < 2)
                    throw new IllegalArgumentException("Invalid postfix expression");

                int op2 = stack.pop();
                int op1 = stack.pop();
                int res = performOperation(op1, op2, ch);
                stack.push(res);
            }
        }

        if (stack.size() != 1)
            throw new IllegalArgumentException("Invalid postfix expression");

        return stack.pop();
    }

    public static void main(String[] args) {
        String postfixS = "4321+*-";  // Example: 4 * (3 - (2 + 1))
        System.out.println("Postfix exp: " + postfixS);
        int res = evaluatePostfixExp(postfixS);
        System.out.println("Evaluation result: " + res);
    }
}
