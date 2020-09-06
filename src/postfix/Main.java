package postfix;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		InfixToPostfix a = new InfixToPostfix();
		
		String postfixed = a.infixToPostfix("3+(2+1)*2^3^2-8/(5-1*2/2)");
		System.out.println(postfixed);
		
		EvaluatePostfixed b = new EvaluatePostfixed();
		
		System.out.println(b.evalPostfix(postfixed));
	}

}
