
public class Stack {

	class Node{
		int data;
		Node nextNode;
		
		Node(int data){
			this.data = data;
			this.nextNode = null;
		}
	}
	
	Node top = null;
	
	public void push(int data) {	//Inserts the node at the beginning of the list in O(1)
		Node newNode = new Node(data);
		if(top == null) {
			//Stack is empty
			top = newNode;
		}else {
			newNode.nextNode = top;
			top = newNode;
		}
	}
	
	public void pop() {
		if(top == null) {
			System.out.println("The Stack is empty. Cannot pop");
		}else {
			Node currentTopNode = top;
			top = top.nextNode;
			
			//Delete
			currentTopNode.nextNode = null;
		}
	}
	
	public void top() {		//Returns the top node value
		if(top == null) {
			System.out.println("The List is empty. Cannot return top node value.");
		}else {
			System.out.println("The top node value is : " + top.data);
		}
	}
	
	public void printStack() {
		if(top == null) {
			System.out.println("The List is empty. Cannot print the stack");
		}else {
			Node tempNode = top;
			while(tempNode != null) {
				System.out.println("Data is : " + tempNode.data);
				tempNode = tempNode.nextNode;
			}	
		}
	}
	
	public static void main(String args[]) {
		System.out.println("Stack Implementation Using Singly LinkedList");
		
		Stack mStack = new Stack();
		
		//Push data to stack
		mStack.push(0);
		mStack.push(1);
		mStack.push(2);
		mStack.push(3);
		mStack.push(4);
		mStack.push(5);
		
		//Print the stack
		mStack.printStack();
		
		//Pop one element
		mStack.pop();
		
		//Print the stack
		System.out.println("\n");
		mStack.printStack();
		
		mStack.push(55);
		
		//Print the stack
		System.out.println("\n");
		mStack.printStack();
		
		//Print the top of the stack
		mStack.top();
		
		//Pop all elements from stack
		mStack.pop();
		mStack.pop();
		mStack.pop();
		mStack.pop();
		mStack.pop();
		mStack.pop();
		
		//Print the stack
		System.out.println("\n");
		mStack.printStack();

	}
}
