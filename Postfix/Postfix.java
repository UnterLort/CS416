import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author Kyle Stewart
 * @version 1
 */

public class Postfix {

    /**
     * 
     * Check if the given string is valid.
     *
     * @param operator The string representing the operator
     * @return The character representing the operator if valid, '?' otherwise
     */
    public static char checkValidOperator(String operator) {
        switch (operator) {
            case "+":
            case "-":
            case "/":
            case "*":
                return operator.charAt(0);
            default:
                return '?';
        }
    }

    /**
     * 
     * Executes the operation based on the operator and operands.
     *
     * @param stack    The stack of operands
     * @param operator The operator
     * @return The result
     */
    public static int execute(Stack<Integer> stack, char operator) {
        int rightOperand = stack.pop();
        int leftOperand = stack.pop();
        int result = 0;
        switch (operator) {
            case '+':
                result = leftOperand + rightOperand;
                break;
            case '-':
                result = leftOperand - rightOperand;
                break;
            case '/':
                result = leftOperand / rightOperand;
                break;
            case '*':
                result = leftOperand * rightOperand;
                break;
        }
        stack.push(result);
        return result;
    }

    /**
     * 
     * Evaluate the given postfix.
     *
     * @param expr The postfix as a string
     * @return The result of the evaluation, or null if evaluation fails
     */
    public static Number evaluateExpression(String expr) {
        String tooFewOperands = "Too few operands";
        String unknownOperator = "Unknown operator: ";
        String tooManyOperands = "Too many operands.";

        Stack<Integer> stack = new Stack<>();
        String errMsg = null;

        Scanner scanner = new Scanner(expr);
        while (scanner.hasNext() && errMsg == null) {
            if (scanner.hasNextInt()) {
                int operand = scanner.nextInt();
                System.out.println("Operand read: " + operand);
                stack.push(operand);
            } else {
                String token = scanner.next();
                char operator = checkValidOperator(token);
                if (operator != '?') {
                    System.out.println("Operator read: " + operator);
                    if (stack.size() >= 2) {
                        execute(stack, operator);
                    } else {
                        errMsg = tooFewOperands;
                    }
                } else {
                    errMsg = unknownOperator + token;
                }
            }
            System.out.println("------ Stack state -----");
            System.out.println(stack);
        }

        if (errMsg != null) {
            System.out.println("Failed evaluation of |" + expr + "|\n" + errMsg);
            return null;
        }

        if (stack.size() != 1) {
            System.out.println("Failed evaluation of |" + expr + "|\n" + tooManyOperands + stack);
            return null;
        }

        return stack.pop();
    }

    /**
     * 
     * Main method to execute the program.
     *
     * @param args The Command line argument
     */
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter a postfix expression");
        String input = inputScanner.nextLine();
        Number result = evaluateExpression(input);
        if (result != null) {
            System.out.println("Expression: " + input + " --> " + result);
        }
        inputScanner.close();
    }
}