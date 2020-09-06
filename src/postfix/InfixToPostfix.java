package postfix;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class InfixToPostfix {

	private static Deque<Character> postfixed = new ArrayDeque<Character>();;
	private static Deque<Character> operators = new LinkedList<Character>();;

	public static boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
			return true;
		}
		return false;
	}

	public static int getPrecedence(char c) {
		switch (c) {
			case '+':
			case '-':
				return 11;
			case '*':
			case '/':
				return 12;
			case '^':
				return 13;
		}
		return -1;
	}

	public String infixToPostfix(String infix) {
		
		for (int i = 0; i < infix.length(); i++) {
			
			char ch = infix.charAt(i);
			
			if (Character.isLetterOrDigit(ch)) {
				postfixed.add(ch);
			}
			if (isOperator(ch)) {
				if (!operators.isEmpty()) {
					while (!operators.isEmpty() &&  
							operators.peek() != '(' &&
							((getPrecedence(ch) < getPrecedence(operators.peek()))	||
							(getPrecedence(ch) == getPrecedence(operators.peek()) &&
							operators.peek() != '^'))) {
						
						char c = operators.pop();
						
						postfixed.add(c);

					}
				}
				operators.push(ch);
			}

			if (ch == '(') {
				operators.push(ch);
			}

			if (ch == ')') {
				while (!operators.isEmpty() && operators.peek() != '(') {
					
					char a = operators.pop();
					
					postfixed.add(a);
				}

				if (operators.isEmpty()) {
					return "The expression has wrong paranthesis!";
				}
				operators.pop();
			}
		}

		while (!operators.isEmpty()) {
			
			char b = operators.pop();
			
			if (b == '(') {
				return "The expression has wrong paranthesis!";
			}
			postfixed.add(b);
		}

		return postfixed.toString();
	}
}
