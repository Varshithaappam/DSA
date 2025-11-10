import java.util.*;

public class InfixConverter {
    public static void main(String[] args) {
        String infixS = "a+b*(c-d)";
        System.out.println("Infix exp: " + infixS);
        String postfixS = convertPostfixExp(infixS);
        System.out.println("Postfix exp: " + postfixS);
    }

    static String convertPostfixExp(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If operand, add to result
            if (Character.isLetterOrDigit(ch))
                res.append(ch);

            // If '(' push to stack
            else if (ch == '(')
                stack.push(ch);

            // If ')' pop until '('
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    res.append(stack.pop());
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    throw new IllegalArgumentException("Invalid Expression");
            }

            // Operator encountered
            else {
                while (!stack.isEmpty() && getPrecedence(ch) <= getPrecedence(stack.peek()))
                    res.append(stack.pop());
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty())
            res.append(stack.pop());

        return res.toString();
    }

    private static int getPrecedence(char c) {
        switch (c) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
            default: return -1;
        }
    }
}
