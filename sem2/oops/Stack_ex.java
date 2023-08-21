import java.util.Stack;

public class Stack_ex

{

	public static void main(String args[])
	
	{
	
		Stack<Integer> stk=new Stack<>();
		
		boolean res=stk.empty();
		
		System.out.println("Is stack empty ="+res);
		
		stk.push(20);
		
		stk.push(22);
		
		System.out.println("Elements of Stack= "+stk);
		
		res=stk.empty();
		
		System.out.println("Is stack empty ="+res);
		
		Integer x=(Integer)stk.pop();
		
		System.out.println("The value poped from stack is= "+x);
		
		stk.push(90);
		
		System.out.println("Elements of stack= "+stk);
		
		x=(Integer)stk.pop();
		
		System.out.println("The value poped from stack is= "+x);
		
		x=(Integer)stk.pop();
		
		System.out.println("The value poped from stack is= "+x);
		
		res=stk.empty();
		
		System.out.println("Is stack empty ="+res);
		
	}
	
}
