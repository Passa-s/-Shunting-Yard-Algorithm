package postfix;

import java.util.Deque;
import java.util.LinkedList;

public class EvaluatePostfixed {
	
	private Deque<String> operands = new LinkedList<String>();
	
	public int calculationOfResult(char operator, int op1, int op2) throws Exception {
        switch (operator){
            case '+':
                return (op2 + op1);
            case '-':
                return (op2 - op1);
            case '*':
                return (op2 * op1);
            case '/':
                return (op2 / op1);
            case '^':
                return (int) Math.pow(op2, op1);
                
            default:
                throw new Exception("Wrong operator!");
        }
    }
	
	public int evalPostfix(String postfixed) throws Exception {
		
		for (int i = 0; i < postfixed.length(); i++) {
			
			char c = postfixed.charAt(i);
			
			String cString = Character.toString(c);
			
			if (Character.isLetterOrDigit(c)) {
				operands.push(cString);
			}

			if (InfixToPostfix.isOperator(c)) {
				if (operands.isEmpty()) {
					System.out.println("The postfixed form is wrong!");
					return 0;
				}
				int op1 = Integer.parseInt((operands.pop()));
				int op2 = Integer.parseInt((operands.pop()));

				int result = calculationOfResult(c, op1, op2);
				
				operands.push(String.valueOf(result));
			}
		}

		int finalRes = Integer.parseInt(operands.pop());
		
		if (!operands.isEmpty()) {
			System.out.println("The postfixed form is wrong!");
			return 0;
		}

		return finalRes;
	}

}
