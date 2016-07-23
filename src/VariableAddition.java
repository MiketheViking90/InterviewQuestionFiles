import java.util.*;

class VariableAddition{
	public static int add(String exp, String[] vars){
		//read in exp
		String[] inputs = exp.split("\\+");

		//read in vars
		HashMap<String, Integer> varDict = new HashMap<String,Integer>();
		for (String var:vars){
			String[] temp = var.split(" ");
			int val = Integer.parseInt(temp[1]);
			String key = temp[0];
			varDict.put(key,val);
		}	

		int sum = 0;
		for (String term:inputs){
			if (isNumeric(term)) {
				sum += Integer.parseInt(term);
			} else {
				sum += varDict.get(term);
			}
		}

		return sum;
	}

	public static boolean isNumeric(String s){
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}

	public static void main(String args[]){
		String exp1 = "1+3+a+xyz+33+num+num";
		String[] vars1 = {"a 999","xyz 0","num 11"};


		System.out.println((add(exp1, vars1)));
	}
}