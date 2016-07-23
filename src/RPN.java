import java.util.*;

class RPN{
	public static int evaluate(String exp){
		Stack<Integer> operands = new Stack<Integer>();
		Stack<String> ops = new Stack<String>();
		int t1, t2, rv;

		rv = 0;
		String[] terms = exp.split(" ");
		for (String term:terms){
			if (isInt(term)) {
				operands.push(Integer.parseInt(term));
			} else {	
				if (term.equals("+")) {
					rv = operands.pop() + operands.pop();
				} else if (term.equals("-")) {
					t1 = operands.pop(); 
					t2 = operands.pop();

					rv = t2 - t1;
				} else if (term.equals("*")) {
					rv = operands.pop() * operands.pop();
				} else if (term .equals("~")) {
					rv = (operands.pop() * (-1));
				}

				operands.push(rv);
			}
		}
		return operands.pop();
	}

	public static boolean isInt(String s){
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
	public static void main(String[] args){
		String exp = "5 10 *  12 -";

		System.out.println((evaluate(exp)));

		System.out.println("df" + String.valueOf(1));
		//System.out.println((evaluate(exp)));
	}
}