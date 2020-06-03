import java.util.Stack;
public class BalancedParentheses {
	
	public void check(String parantheses) {
		
		Stack<Character> mStack = new Stack<Character>();
		
		for(int i = 0 ; i < parantheses.length() ; i ++) {
			Character currentCharacter = parantheses.charAt(i);
			if(currentCharacter.equals('(') || currentCharacter.equals('[') || currentCharacter.equals('{')) {
				mStack.push(currentCharacter);
			}else {
				if(mStack.isEmpty()) {
					System.out.println("Not balanced as no Opening Brace Found.");
					return;
				}else {
				Character currentTop = mStack.pop();
				
				switch(currentCharacter) {
				case ')':
					if(!currentTop.equals('(')) {
						System.out.println("Not Balanced");
						return;
					}
					break;
				case '}':
					if(!currentTop.equals('{')) {
						System.out.println("Not Balanced");
						return;
					}
					break;
			
				case ']':
					if(!currentTop.equals('[')) {
						System.out.println("Not Balanced");
						return;
					}
					break;	
					}
				}
			}
		}
		
		if(!mStack.isEmpty()) {
			System.out.println("Not Balanced as one of the closing braces is missing.");
			return;
		}else {
			System.out.println("Balanced");
		}
		//mStack.forEach(System.out::println);
	}
	
	public static void main(String args[]) {
		BalancedParentheses mBalancedParentheses = new BalancedParentheses();
		//Balanced
		mBalancedParentheses.check("({[([])]})");
		
		//Not Balanced
		mBalancedParentheses.check("({[([])])");
		
		//Not Balanced
		mBalancedParentheses.check(")");
		
		//Not Balanced
		mBalancedParentheses.check("(");
		
		//Not Balanced
		mBalancedParentheses.check("({[)");
		
		//Not Balanced
		mBalancedParentheses.check("({[([)))");
		
		//Balanced
		mBalancedParentheses.check("()");
		
		//Balanced
		mBalancedParentheses.check("");
	}
}
