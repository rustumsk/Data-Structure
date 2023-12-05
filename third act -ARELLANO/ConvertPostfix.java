import java.util.Stack;
import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

public class ConvertPostfix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int i = 0;
        while(i == 0){
            try{
                System.out.print("Enter infix to convert to postfix(without spaces! example: (1+2-3)): ");
                String infix = scan.nextLine();
                Convert convert = new Convert(infix);

                String postfix = convert.convertPostfix();

                System.out.println("Postfix: "+ postfix);

                double result = convert.evaluateExpression(postfix);
                System.out.println("Result: "+result);
            }
            catch(NumberFormatException e){
                System.out.println("Goodbye!");
                i = 1;
            }
        }

        scan.close();
    }
}

class Convert {
    private StringBuilder nResult = new StringBuilder();
    private Stack<Character> operator = new Stack<>();
    public static ArrayList<String>express = new ArrayList<>();
    StringBuilder tempo = new StringBuilder();
    private Stack<String> operand = new Stack<>();
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
            } else if (c == '(') { //check if there is an opening parenthesis
                operator.push(c); // if there is then push it to the operator stack
            } else if (c == ')') {//check if there is a closing parenthesis
                while (operator.peek() != '(') { //if its not an opening parenthesis
                    nResult.append(operator.pop()).append(" ");// append the operators on the result
                }
                operator.pop();//pop the opening parenthesis
            }
            else {
                if (c == '-' && Character.isDigit(passed.charAt(i + 1))) {
                    StringBuilder nMulti = new StringBuilder();
                    nMulti.append(c);
                    i++;
                    while (i < passed.length() && Character.isDigit(passed.charAt(i))) {
                        nMulti.append(passed.charAt(i));
                        i++;
                    }
                    nResult.append(nMulti.toString()).append(" ");
                    i--; // Decrement i to revisit the operator character
                }
                else if (operator.isEmpty() || operator.peek() == '(') {
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

        String result = nResult.toString();
        return result;
    }
    double evaluateExpression(String expression){
        double result = 0;
        String[] token = expression.split(" ");
        
        for (int i = 0; i < token.length; i++){
            if (token[i].equals("+") || token[i].equals("-") || token[i].equals("/") || token[i].equals("*") || token[i].equals("^")) {//this checks if the token is an operator
                operand.push(token[i]);//this pushes the operator just so i can print it on step by step operation
                System.out.println(operand);//printing the stack 
                operand.pop();//popping the operator before its evaluated
                double operand2 = Double.parseDouble(operand.pop());//if its an operator, pop the operand
                double operand1 = Double.parseDouble(operand.pop());
                

                switch (token[i]) { //this evaluates the expression.
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand2 / operand1;
                        break;
                    case "^": 
                        result = Math.pow(operand2, operand1);
                        break;
                }
            operand.push(String.valueOf(result)); // this adds the resulting evaluated expression into the operand stack, until the loop is done.
            }
            else {
                operand.push(token[i]);// if the token is not an operator, then push the token into operand stack
            }
        }
        result = Double.parseDouble(operand.pop()); //this parses the result into double after the loop is done, because the expression is now evaluated.
        return result;
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