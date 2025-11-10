import java.util.*;

class PostFixEval {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        char[] s = {'5', '2', '+', '7', '3', '-', '*'};
        int result = 0;

        for (char c : s) {
            if (isOperator(c)) {
                int val2 = stack.pop();  
                int val1 = stack.pop(); 

                switch (c) {
                    case '+':
                        result = val1 + val2;
                        break;
                    case '-':
                        result = val1 - val2;
                        break;
                    case '*':
                        result = val1 * val2;
                        break;
                    case '/':
                        result = val1 / val2;
                        break;
                }

                stack.push(result);
            } else {
                stack.push(c - '0');
            }
        }

        System.out.println("Result: " + stack.pop());
    }

    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
