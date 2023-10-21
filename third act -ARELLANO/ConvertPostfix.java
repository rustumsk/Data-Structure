import java.util.Stack;
import java.util.Scanner;

public class ConvertPostfix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter infix to convert to postfix(without spaces! example: (1+2-3)): ");
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
                StringBuilder multi = new StringBuilder();
                while (i < passed.length() && Character.isDigit(passed.charAt(i))) { // this adds and appends the character whether it is multi digit or single.
                    multi.append(passed.charAt(i));
                    i++;// increment so the count will iterate correctly.
                }
                nResult.append(multi).append(" ");;
                i--; // Decrement i to revisit the operator character
            } else if (c == '(') { //check if there is a parenthesis
                operator.push(c);
            } else if (c == ')') {
                while (operator.peek() != '(') { //if it encounters a closing parenthisis it appends all
                    nResult.append(operator.pop()).append(" ");
                }
                operator.pop();
            } else {
                if (operator.isEmpty() || operator.peek() == '(') {
                    operator.push(c);
                } else {
                    while (!operator.isEmpty() && checkPrecedence(c) <= checkPrecedence(operator.peek())) {
                        nResult.append(operator.pop()).append(" ");
                    }
                    operator.push(c);
                }
            }
        }

        while (!operator.isEmpty()) {
            nResult.append(operator.pop()).append(" ");
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