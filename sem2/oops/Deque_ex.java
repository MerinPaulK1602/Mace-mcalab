import java.util.*;

public class Deque_ex{

	public static void main(String[] args){
	
		Deque<String> deque = new LinkedList<String>();
		
		deque.add(" and vegetables");
		
		deque.addFirst("Fruit");
		
		deque.addLast("are");
		
		System.out.println("Initial Deque:");
		
		System.out.print(deque+" ");
		
		deque.push("A");
		
		deque.offer("Good");
		
		deque.offerFirst("Daily");
		
		deque.offerLast("for health");
		
		System.out.println("\nDeque");
		
		System.out.print(deque + " ");
		
		System.out.print("\n\nDeque contents using Standard Iterator: ");
		
		Iterator iterator = deque.iterator();
		
		while (iterator.hasNext())
		
			System.out.print(" "+iterator.next());
			
		Iterator reverse = deque.descendingIterator();
			
		System.out.print("\n\nDeque contents using reverse Iterator: ");
			
		while (reverse.hasNext())
			
			System.out.print(" "+reverse.next());
			
		System.out.println("\n\nDeque Peek:"+deque.peek());
			
		System.out.println("\n\nDeque, After Peek:"+deque);
		
		System.out.println("\n\nDeque Pop:"+deque.pop());
		
		System.out.println("\n\nDeque, After Pop:"+deque);
		
		System.out.println("\nDeque contains Three:"+deque.contains("Three"));
		
		deque.removeFirst();
		
		deque.removeLast();
		
		System.out.println("\nDeque, after removing" + "first and last elements:"+deque);
		
	}
		
}		
			
			
