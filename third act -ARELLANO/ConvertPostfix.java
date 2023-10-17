import java.util.Stack;
import java.util.Scanner;
public class ConvertPostfix {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter infix to convert to postfix: ");
        String infix = scan.nextLine();
        Convert convert = new Convert(infix);   

        String result = convert.convertPostfix();

        System.out.println(result);

        scan.close();
        
    }
}
class Convert {
    private StringBuilder nResult = new StringBuilder();
    private Stack<Character> operator = new Stack<>();
    String passed;

    public Convert(String passed) {
        this.passed = passed;
    }

    public String convertPostfix() {
        for (int i = 0; i < passed.length(); i++) {
            char c = passed.charAt(i);

            if (Character.isDigit(c)) {
                nResult.append(c); // Append operands directly to nResult
            } else if (c == '(') {
                operator.push(c);
            } else if (c == ')') {
                while (operator.peek() != '(') {
                    nResult.append(operator.pop()); // Append operators to nResult
                }
                operator.pop(); // Pop the opening parenthesis
            } else {
                if (operator.isEmpty()) {
                    operator.push(c);
                } else {
                    while (!operator.isEmpty() && checkPrecedence(c) <= checkPrecedence(operator.peek())) {
                        nResult.append(operator.pop()); // Append operators to nResult
                    }
                    operator.push(c);
                }
            }
        }

        while (!operator.isEmpty()) {
            nResult.append(operator.pop()); // Append remaining operators to nResult
        }

        return nResult.toString();
    }

    int checkPrecedence(char operator) {
        switch (operator) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }
}